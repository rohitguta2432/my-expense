package com.delte.api.service;

import com.delte.api.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author rohit
 * @Date 06/09/21
 **/
public interface UserService {
    UserDetails loadUsernameAndPassword(String username, String password);
    UserMapper create(UserMapper userMapper);
}
