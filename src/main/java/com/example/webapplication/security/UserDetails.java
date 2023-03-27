package com.example.webapplication.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {
    Collection<? extends GrantedAuthority> getAuthorities();
    String getPassword();

    String getUsername();

    Boolean isAccountNonExpired();
    Boolean isAccountNonLocked();
    Boolean isCredentialsNonExpired();
    Boolean isEnabled();
}
