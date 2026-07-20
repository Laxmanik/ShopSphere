package com.laxman.shopsphere.user.service;

import com.laxman.shopsphere.user.dto.request.RegisterRequest;
import com.laxman.shopsphere.user.dto.response.UserResponse;

public interface UserService {

    UserResponse registerUser(RegisterRequest request);
}