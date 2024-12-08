package com.virtuous.bookmytripuserservice.controller;

import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import com.virtuous.bookmytripuserservice.dto.response.UserResponse;
import com.virtuous.bookmytripuserservice.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @SecurityRequirement(name = "Authorization")
    @GetMapping()
    public GenericResponse<List<UserResponse>> getAllUsers() {
        return GenericResponse.success(userService.getAllUsers(), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @GetMapping("/{email}")
    public GenericResponse<UserResponse> getUserByEmail(@PathVariable String email) {
        return GenericResponse.success(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @GetMapping("/me")
    public GenericResponse<UserResponse> getProfile() {
        return GenericResponse.success(userService.getProfile(), HttpStatus.OK);
    }
}
