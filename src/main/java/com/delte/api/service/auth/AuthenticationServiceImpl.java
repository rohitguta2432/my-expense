package com.delte.api.service.auth;

import com.delte.api.mapper.UserDto;
import com.delte.api.model.AuthToken;
import com.delte.api.model.ExpenseUser;
import com.delte.api.repository.AuthRepository;
import com.delte.api.service.UserService;
import com.delte.api.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author rohit
 * @Date 07/09/21
 **/
@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public Map<String, Object> authenticateUser(UserDto userDto) {
        log.debug("Authenticating user : {}", userDto);

        Map<String, Object> map = new HashMap<String, Object>();
        String token = "";
        ExpenseUser user = (ExpenseUser) userDetailsService
                .loadUsernameAndPassword(userDto.getUsername(), userDto.getPassword());

        AuthToken authToken = authRepository.findByUserId(user.getUserId());

        if (ObjectUtils.isEmpty(authToken)) {
            token = tokenUtils.generateToken(user.getUsername());
            AuthToken authTokens = AuthToken.builder()
                    .userId(user.getUserId())
                    .token(token)
                    .build();
            authRepository.save(authTokens);
        } else {
            token = authToken.getToken();
        }
        map.put("user", user);
        map.put("token", token);
        return map;
    }
}
