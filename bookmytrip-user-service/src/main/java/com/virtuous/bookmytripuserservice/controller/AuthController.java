package com.virtuous.bookmytripuserservice.controller;

import com.virtuous.bookmytripuserservice.dto.request.UserLoginRequest;
import com.virtuous.bookmytripuserservice.dto.request.UserSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import com.virtuous.bookmytripuserservice.dto.response.UserResponse;
import com.virtuous.bookmytripuserservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/register")
    public GenericResponse<UserResponse> register(@RequestBody UserSaveRequest request) {
        return GenericResponse.success(authService.register(request), HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
