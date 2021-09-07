package com.delte.api.service.auth;

import com.delte.api.mapper.UserDto;

import java.util.Map;

/**
 * @Author rohit
 * @Date 07/09/21
 **/
public interface AuthenticationService {
    Map<String, Object> authenticateUser(UserDto userDto);

}
