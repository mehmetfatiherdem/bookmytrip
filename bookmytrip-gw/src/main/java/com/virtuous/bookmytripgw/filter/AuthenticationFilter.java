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
            "/api/v1/auth/login"
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

            // validator.isSecured.test(request)
            if (adminOnlyRoutes.stream().anyMatch(path::startsWith) || (globalRoutes.stream().noneMatch(path::startsWith) && method != HttpMethod.GET)) {

                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();

                }


                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).trim();

                if (authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
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
