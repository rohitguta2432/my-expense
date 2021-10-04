package com.delte.api.mapper;

import lombok.Data;

import java.util.Map;

/**
 * @Author rohit
 * @Date 07/09/21
 **/

@Data
public class UserMapper {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String mobile;
    private String authority;

    Map<String, String> userDetails;
}
