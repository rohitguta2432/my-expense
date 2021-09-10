package com.delte.api.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 07/09/21
 **/

@Data
public class ExpenseUser implements UserDetails {

    private UUID userId;
    private String userName;
    private Collection<? extends GrantedAuthority> authorities;
    private String emailId;


    public ExpenseUser(UUID userId, String userName,
                       Collection<? extends GrantedAuthority> authorities, String email) {
        this.setUserId(userId);
        this.setUserName(userName);
        this.setAuthorities(authorities);
        this.setEmailId(email);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.userName;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
