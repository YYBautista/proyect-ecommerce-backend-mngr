package com.seiryu.ecommerce.backend_ecommerce.infrastructure.jwt;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.seiryu.ecommerce.backend_ecommerce.infrastructure.service.CustomUserDetailService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private CustomUserDetailService customUserDetailService;

    public JwtAuthorizationFilter(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws IOException, ServletException {

        try {

            if (JWTValidate.tokenExist(request, response)) {

                Claims claims = JWTValidate.JWTValid(request);

                if (claims.get("authorities") != null) {

                    JWTValidate.setAuthentication(claims, customUserDetailService);

                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {

                SecurityContextHolder.clearContext();
            }

            filterChain.doFilter(request, response);

        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {

            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;

        }

    }

}
