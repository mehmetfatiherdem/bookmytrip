package com.virtuous.bookmytripuserservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    // /flights/COV-SAW/2024-12-06?sort=bestflight_a
    private static final String[] AUTH_WHITELIST = {
            "/api/v1/auth/login",
            "/api/v1/auth/register"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/v1/roles/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/user-roles/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/v1/airports").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/airports").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/airports").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/airports").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/v1/airports").permitAll()
                                .requestMatchers(AUTH_WHITELIST).permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

