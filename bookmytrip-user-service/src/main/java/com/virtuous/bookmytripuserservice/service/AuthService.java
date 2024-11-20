package com.virtuous.bookmytripuserservice.service;

import com.virtuous.bookmytripuserservice.dto.request.UserLoginRequest;
import com.virtuous.bookmytripuserservice.dto.request.UserSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.UserResponse;
import com.virtuous.bookmytripuserservice.exception.BookMyTripException;
import com.virtuous.bookmytripuserservice.exception.ExceptionMessages;
import com.virtuous.bookmytripuserservice.model.User;
import com.virtuous.bookmytripuserservice.model.enums.RoleName;
import com.virtuous.bookmytripuserservice.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RedisTemplate<String, String> redisTemplate;

    public UserResponse register(UserSaveRequest request) {

        boolean isExists = userService.existsByEmail(request.getEmail());

        if (isExists) {
            throw new BookMyTripException(ExceptionMessages.USER_ALREADY_DEFINED);
        }

        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));

        return userService.createUser(request, RoleName.USER);

    }

    public String login(UserLoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = userService.findByEmail(request.getEmail());

        return jwtUtil.generateToken(user);

    }

    public String logout(String authHeader) {
        String token = jwtUtil.extractToken(authHeader);

        // Add the token to Redis blacklist
        try {

            long expiration = jwtUtil.extractExpiration(token).getTime();
            redisTemplate.opsForValue().set("token:" + token, "revoked", expiration, TimeUnit.MILLISECONDS);
            return "Logged out successfully";

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid token: Unable to extract expiration.", e);
        }


    }

}
