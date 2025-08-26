package com.seiryu.ecommerce.backend_ecommerce.infrastructure.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.seiryu.ecommerce.backend_ecommerce.application.UserService;
import com.seiryu.ecommerce.backend_ecommerce.domain.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    private UserService userService;

    // Constructor
    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByEmail(username);

        return org.springframework.security.core.userdetails.User.builder().username(user.getEmail())
                .password(user.getPassword()).roles(user.getUserType().name()).build();

    }

}
