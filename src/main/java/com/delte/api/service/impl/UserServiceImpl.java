package com.delte.api.service.impl;

import com.delte.api.mapper.UserDto;
import com.delte.api.mapper.UserMapper;
import com.delte.api.model.ExpenseUser;
import com.delte.api.model.User;
import com.delte.api.repository.UserRepository;
import com.delte.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * @Author rohit
 * @Date 06/09/21
 **/

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUsernameAndPassword(String username, String password) {
        log.info("fetch user by username : {} ", username);

        User user = userRepository.findByUserName(username);

        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("No user found with username");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UsernameNotFoundException("Invalid Crendials..");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        Arrays.asList(user.getAuthority())
                .forEach(a -> {
                    authorities.add(new SimpleGrantedAuthority(a));
                });

        return new ExpenseUser(user.getUserId(), user.getUserName(),
                authorities
                , user.getEmail());
    }

    @Override
    public UserMapper create(UserMapper userMapper) {
        log.info("create user : {} ", userMapper);
        Map<String, String> message = new HashMap<>();
        User user = new User();
        user.setUserName(userMapper.getUsername());
        user.setEmail(userMapper.getEmail());
        user.setFirstName(userMapper.getFirstName());
        user.setMobile(userMapper.getMobile());
        user.setPassword(passwordEncoder.encode(userMapper.getPassword()));
        user.setAuthority(userMapper.getAuthority());
        userRepository.save(user);
        message.put("message", "user created successfully ..");
        userMapper.setMessage(message);

        return userMapper;
    }
}
