package org.boot.security.beans.service;

import lombok.RequiredArgsConstructor;
import org.boot.entities.User;
import org.boot.repositories.UserRepository;
import org.boot.security.beans.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username" + username + " not found");
        }
        userDetails = new UserDetailsImpl(user.getRole().getRoleName(), user.getPassword(), user.getStatus(), user.getUsername());
        return userDetails;
    }



}
