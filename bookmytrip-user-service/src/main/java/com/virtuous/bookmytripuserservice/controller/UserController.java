package com.virtuous.bookmytripuserservice.controller;

import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import com.virtuous.bookmytripuserservice.dto.response.UserResponse;
import com.virtuous.bookmytripuserservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public GenericResponse<UserResponse> getProfile() {
        return GenericResponse.success(userService.getProfile(), HttpStatus.OK);
    }
}
