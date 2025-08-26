package com.seiryu.ecommerce.backend_ecommerce.infrastructure.jwt;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtGenerator {

    public String generateToken(String username) {

        List<GrantedAuthority> authoritiesList = AuthorityUtils.commaSeparatedStringToAuthorityList(

                SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                        .findFirst().toString());

        String token = Jwts.builder()
                .setId("ecommerce")
                .setSubject(username)
                .claim("authorities",
                        authoritiesList.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Constants.JWT_EXPIRATION_TIME))
                .signWith(Constants.getSignedKey(Constants.JWT_SECRET_KEY), SignatureAlgorithm.HS512)
                .compact();

        return "Bearer " + token;

    }

}
