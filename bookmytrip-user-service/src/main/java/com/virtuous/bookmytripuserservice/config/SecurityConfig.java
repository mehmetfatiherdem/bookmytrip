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
            "/api/v1/auth/login/**",
            "/api/v1/auth/register/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests

                                // globally accessible
                                .requestMatchers(HttpMethod.GET, "/api/v1/airlines/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/airports/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/buses/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/bus-operators/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/bus-seats/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/bus-terminals/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/bus-tickets/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/planes/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/plane-seats/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/plane-tickets/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/tickets/**").permitAll()

                                // only admin-level accessible endpoints
                                .requestMatchers("/api/v1/roles/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/user-roles/**").hasAuthority("ADMIN")

                                // only admin-level accessible endpoint-methods
                                .requestMatchers(HttpMethod.POST, "/api/v1/airlines/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/airlines/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/airlines/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/airlines/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/airports/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/airports/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/airports/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/airports/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/buses/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/buses/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/buses/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/buses/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/bus-operators/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/bus-operators/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/bus-operators/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/bus-operators/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/bus-seats/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/bus-seats/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/bus-seats/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/bus-seats/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/bus-terminals/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/bus-terminals/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/bus-terminals/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/bus-terminals/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/bus-tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/bus-tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/bus-tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/bus-tickets/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/planes/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/planes/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/planes/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/planes/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/plane-seats/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/plane-seats/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/plane-seats/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/plane-seats/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/plane-tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/plane-tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/plane-tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/plane-tickets/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/tickets/**").hasAuthority("ADMIN")

                                // whitelists
                                .requestMatchers(AUTH_WHITELIST).permitAll()

                                //**********************************************************************
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

