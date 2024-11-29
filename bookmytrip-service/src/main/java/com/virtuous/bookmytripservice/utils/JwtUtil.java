package com.virtuous.bookmytripservice.utils;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.List;


@Component
public class JwtUtil {

    public final String SECRET;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public JwtUtil(@Value("${spring.jwt.secret}") String secret) {
        this.SECRET = secret;
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String extractUserId(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("userId", String.class);
    }

    public String extractJwtFromHeader() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean isUserRevoked(String token, String userId) {
        Claims claims = extractAllClaims(token);
        long tokenIssuedAt = claims.getIssuedAt().getTime();

        String revokedAt = redisTemplate.opsForValue().get("user:" + userId + ":revokedAt");

        if (revokedAt == null) {
            return false;
        }

        return tokenIssuedAt < Long.parseLong(revokedAt);
    }

    public boolean isTokenRevoked(String token) {
        return redisTemplate.opsForValue().get("token:" + token) != null;
    }


    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    // Extract roles from the token
    public List<String> extractRoles(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("roles", List.class);
    }

    // Extract the subject (username) from the token
    public String extractSubject(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject(); // Extract the username (subject)
    }

    // Check if the token is expired
    public boolean isTokenExpired(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration().before(new Date());
    }

}
