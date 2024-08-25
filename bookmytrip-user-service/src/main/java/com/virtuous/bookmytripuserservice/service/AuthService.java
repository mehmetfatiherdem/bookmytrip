package com.virtuous.bookmytripuserservice.service;

import com.virtuous.bookmytripuserservice.dto.request.UserLoginRequest;
import com.virtuous.bookmytripuserservice.dto.request.UserSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.UserResponse;
import com.virtuous.bookmytripuserservice.exception.BookMyTripException;
import com.virtuous.bookmytripuserservice.exception.ExceptionMessages;
import com.virtuous.bookmytripuserservice.model.User;
import com.virtuous.bookmytripuserservice.model.enums.RoleType;
import com.virtuous.bookmytripuserservice.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserResponse register(UserSaveRequest request) {

        boolean isExists = userService.existsByEmail(request.getEmail());

        if (isExists) {
            throw new BookMyTripException(ExceptionMessages.USER_ALREADY_DEFINED);
        }

        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));

        return userService.createUser(request, RoleType.USER);

    }

    public String login(UserLoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = userService.findByEmail(request.getEmail());

        return jwtUtil.generateToken(user);

    }
}
