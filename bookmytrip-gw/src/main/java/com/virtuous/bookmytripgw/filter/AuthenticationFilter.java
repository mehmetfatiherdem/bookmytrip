package com.virtuous.bookmytripgw.filter;

import com.virtuous.bookmytripgw.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private JwtUtil jwtUtil;

    private final List<String> adminOnlyRoutes = List.of(
            "/api/v1/roles/**",
            "/api/v1/user-roles/**"
    );

    public static final List<String> globalRoutes = List.of(
            "/api/v1/auth/register",
            "/api/v1/auth/login",
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

            "/user-service/swagger-ui.html",
            "/user-service/swagger-ui/**",
            "/user-service/v3/api-docs/**",
            "/user-service/v3/api-docs.yaml",
            "/user-service/swagger-resources",
            "/user-service/swagger-resources/**",
            "/user-service/configuration/ui",
            "/user-service/configuration/security",
            "/user-service/swagger-ui/**",
            "/user-service/webjars/**"
    );

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {

            ServerHttpRequest request = exchange.getRequest();

            String path = request.getURI().getPath();
            HttpMethod method = exchange.getRequest().getMethod();

            if (path.startsWith("/api/v1/auth/logout") || adminOnlyRoutes.stream().anyMatch(path::startsWith) || (globalRoutes.stream().noneMatch(path::startsWith) && method != HttpMethod.GET)) {

                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();

                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).trim();

                if (authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }

                var userId = jwtUtil.extractUserId(authHeader);

                // Check if token is revoked
                if (jwtUtil.isTokenRevoked(authHeader) || jwtUtil.isUserRevoked(authHeader, userId)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }


                if (jwtUtil.isTokenExpired(authHeader)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }

                try {

                    jwtUtil.extractAllClaims(authHeader);

                    request = exchange.getRequest().mutate()
                            .header(HttpHeaders.AUTHORIZATION, "Bearer " + authHeader)
                            .build();



                } catch (Exception e) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            }

            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    public static class Config{

    }

}
