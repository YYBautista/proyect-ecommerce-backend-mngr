package com.seiryu.ecommerce.backend_ecommerce.infrastructure.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import io.jsonwebtoken.security.Keys;

public class Constants {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    public static final String JWT_SECRET_KEY = "9ai4Q53uy0dPS72EHlsOTWIvWLRLSUAXjTdiVfhPNymYIkHUyTj5VTPdGWm7n9ATSBpWOH";
    public static final long JWT_EXPIRATION_TIME = 1800000; // 30 minutes

    public static Key getSignedKey(String secretKey) {

        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);

    }

}
