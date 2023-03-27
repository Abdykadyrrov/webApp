package com.example.webapplication.model;

import com.example.webapplication.security.UserDetails;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="user")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "user_sequence"
    )
    private Long id;
    private String username;
    private String password;
    private String role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return getUsername();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));

    }

    @Override
    public Boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public Boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public Boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Boolean isEnabled() {
        return true;
    }
}

