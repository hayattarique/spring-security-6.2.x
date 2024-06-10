package org.boot.security.beans;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String status;

    public UserDetailsImpl(String role, String password, String status, String username) {
        this.authorities = List.of(new SimpleGrantedAuthority(role));
        this.password = password;
        this.status = status;
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !status.equals("E");
    }

    @Override
    public boolean isAccountNonLocked() {
        return !status.equals("L");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !status.equals("E");
    }

    @Override
    public boolean isEnabled() {
        return status.equals("A");
    }
}
