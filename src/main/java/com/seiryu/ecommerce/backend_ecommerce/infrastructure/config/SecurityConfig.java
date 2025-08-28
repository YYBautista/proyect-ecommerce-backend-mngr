package com.seiryu.ecommerce.backend_ecommerce.infrastructure.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.seiryu.ecommerce.backend_ecommerce.infrastructure.jwt.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    public SecurityConfig(JwtAuthorizationFilter jwtAuthorizationFilter) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    /**
     * @param httpSecurity
     * @return SecurityFilterChain
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors(
                cors -> cors.configurationSource(
                        request -> {
                            CorsConfiguration corsConfiguration = new CorsConfiguration();
                            corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
                            corsConfiguration
                                    .setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                            corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
                            return corsConfiguration;
                        }))

                .csrf(csrf -> csrf.disable()).authorizeHttpRequests(
                        aut -> aut.requestMatchers("/api/v1/admin/categories/**").hasRole("ADMIN")
                                .requestMatchers("/api/v1/admin/products/**").hasRole("ADMIN")
                                .requestMatchers("/api/v1/orders/**").hasRole("USER")
                                .requestMatchers("/api/v1/payments/**").hasRole("USER")
                                .requestMatchers("/images/**").permitAll()
                                .requestMatchers("/api/v1/home/**").permitAll()
                                .requestMatchers("/api/v1/auth/**").permitAll().anyRequest().authenticated())
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    /**
     * @return BCryptPasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
