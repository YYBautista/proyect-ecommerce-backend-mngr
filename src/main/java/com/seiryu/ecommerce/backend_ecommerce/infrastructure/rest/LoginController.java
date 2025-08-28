package com.seiryu.ecommerce.backend_ecommerce.infrastructure.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seiryu.ecommerce.backend_ecommerce.application.UserService;
import com.seiryu.ecommerce.backend_ecommerce.domain.model.User;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.dto.JwtClient;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.dto.UserDTO;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.jwt.JwtGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtGenerator jwtGenerator;

    public LoginController(UserService userService, AuthenticationManager authenticationManager,
            JwtGenerator jwtGenerator) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtClient> login(@RequestBody UserDTO userDTO) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        userDTO.username(), userDTO.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        log.info("Role user: {}", SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .findFirst().get().toString());

        User user = userService.findByEmail(userDTO.username());

        String token = jwtGenerator.generateToken(userDTO.username());

        JwtClient jwtClient = new JwtClient(user.getId(), token);

        return new ResponseEntity<>(jwtClient, HttpStatus.OK);
    }

}
