package com.virtuous.bookmytripuserservice.controller;

import com.virtuous.bookmytripuserservice.dto.request.UserLoginRequest;
import com.virtuous.bookmytripuserservice.dto.request.UserSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import com.virtuous.bookmytripuserservice.dto.response.UserResponse;
import com.virtuous.bookmytripuserservice.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/register")
    public GenericResponse<UserResponse> register(@Valid @RequestBody UserSaveRequest request) {
        return GenericResponse.success(authService.register(request), HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping(path = "/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authHeader) {
        return ResponseEntity.ok(authService.logout(authHeader));
    }
}
