package com.virtuous.bookmytripservice.config;

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

    private static final String[] AUTH_WHITELIST = {
            "/bookmytrip-service/swagger-ui.html",
            "/bookmytrip-service/swagger-ui/**",
            "/bookmytrip-service/v3/api-docs/**",
            "/bookmytrip-service/v3/api-docs.yaml",
            "/bookmytrip-service/swagger-resources",
            "/bookmytrip-service/swagger-resources/**",
            "/bookmytrip-service/configuration/ui",
            "/bookmytrip-service/configuration/security",
            "/bookmytrip-service/swagger-ui/**",
            "/bookmytrip-service/webjars/**",
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"))
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests

                                // globally accessible
                                .requestMatchers(HttpMethod.GET, "/api/v1/airlines/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/airports/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/buses/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/bus-operators/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/bus-seats/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/bus-terminals/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/bus-trips/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/planes/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/plane-seats/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/flights/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/trips/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/tickets/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/flight-tickets/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/bus-tickets/**").permitAll()

                                .requestMatchers(AUTH_WHITELIST).permitAll()


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

                                .requestMatchers(HttpMethod.POST, "/api/v1/bus-trips/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/bus-trips/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/bus-trips/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/bus-trips/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/planes/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/planes/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/planes/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/planes/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/plane-seats/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/plane-seats/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/plane-seats/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/plane-seats/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/flights/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/flights/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/flights/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/flights/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/trips/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/trips/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/v1/trips/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/trips/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/flight-tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/flight-tickets/**").hasAuthority("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/bus-tickets/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/bus-tickets/**").hasAuthority("ADMIN")

                                //**********************************************************************
                                //.requestMatchers(HttpMethod.OPTIONS).permitAll()

                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
