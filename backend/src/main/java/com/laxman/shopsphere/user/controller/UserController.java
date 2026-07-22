package com.laxman.shopsphere.user.controller;

import com.laxman.shopsphere.user.dto.request.RegisterRequest;
import com.laxman.shopsphere.user.dto.response.UserResponse;
import com.laxman.shopsphere.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterRequest request) {

        UserResponse userResponse = userService.registerUser(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponse);
    }
}