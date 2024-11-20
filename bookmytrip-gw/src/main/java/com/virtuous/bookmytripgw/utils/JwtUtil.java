package com.virtuous.bookmytripgw.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;


@Component
public class JwtUtil {

    public final String SECRET;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public JwtUtil(@Value("${spring.jwt.secret}") String secret) {
        this.SECRET = secret;
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isUserRevoked(String token, String userId) {
        Claims claims = extractAllClaims(token);
        long tokenIssuedAt = claims.getIssuedAt().getTime();

        // Fetch the revokedAt value from Redis
        String revokedAt = redisTemplate.opsForValue().get("user:" + userId + ":revokedAt");

        // Log the revokedAt for debugging (remove this in production)
        if (revokedAt != null) {
            System.out.println("########################## token: " + token + " revokedAt: " + revokedAt); // TODO: remove this
        }

        // Check if the token is revoked
        if (revokedAt == null) {
            return false; // Token is not revoked because no revocation time exists
        }

        // If the token was issued before the revocation time, it is revoked
        return tokenIssuedAt < Long.parseLong(revokedAt);
    }

    public boolean isTokenRevoked(String token) {
        if (redisTemplate.opsForValue().get("token:" + token) != null) {
            System.out.println("************** is token revoked: yes, token: " + redisTemplate.opsForValue().get(token));
            return true;
        }

        return false;

        // TODO: use the one liner below after testing
        // return redisTemplate.opsForValue().get(token) != null
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUserId(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("userId", String.class);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
