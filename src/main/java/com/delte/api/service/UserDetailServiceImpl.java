package com.delte.api.service;

import com.delte.api.model.ExpenseUser;
import com.delte.api.model.User;
import com.delte.api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Author rohit
 * @Date 07/09/21
 **/

@Slf4j
@Service("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {

        User user = userRepository.findByUserName(username);

        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("No User Found with Username");
        }
        return new ExpenseUser(user.getUserId(), user.getUserName(),
                AuthorityUtils.
                        commaSeparatedStringToAuthorityList(user.getAuthority()),
                user.getEmail());
    }
}
