package com.virtuous.bookmytripservice.utils;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class JwtUtil {

    public final String SECRET;

    public JwtUtil(@Value("${spring.jwt.secret}") String secret) {
        this.SECRET = secret;
    }

    // Validate the token
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token);  // This will throw an exception if the token is invalid
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false; // Invalid token
        }
    }

    // Extract the claims (including roles) from the token
    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    // Extract roles from the token
    public List<String> extractRoles(String token) {
        Claims claims = extractClaims(token);
        return claims.get("roles", List.class);
    }

    // Extract the subject (username) from the token
    public String extractSubject(String token) {
        Claims claims = extractClaims(token);
        return claims.getSubject(); // Extract the username (subject)
    }

    // Check if the token is expired
    public boolean isTokenExpired(String token) {
        Claims claims = extractClaims(token);
        return claims.getExpiration().before(new Date());
    }

}
