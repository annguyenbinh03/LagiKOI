package com.lagikoi.be.controller;

import com.lagikoi.be.dto.request.UserCreationRequest;
import com.lagikoi.be.dto.response.ApiResponse;
import com.lagikoi.be.dto.response.UserResponse;
import com.lagikoi.be.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping("/create")
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping("/info/{username}")
    public ApiResponse<UserResponse> getUserInfo(@PathVariable("username") String username) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUserInfo(username))
                .build();
    }

    @GetMapping("/info/all")
    public ApiResponse<List<UserResponse>> getAllUserInfo() {
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getAllUserInfo())
                .build();
    }
}
