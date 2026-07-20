package com.laxman.shopsphere.user.service.impl;

import com.laxman.shopsphere.common.enums.RoleType;
import com.laxman.shopsphere.common.exception.EmailAlreadyExistsException;
import com.laxman.shopsphere.common.exception.RoleNotFoundException;
import com.laxman.shopsphere.role.entity.Role;
import com.laxman.shopsphere.role.repository.RoleRepository;
import com.laxman.shopsphere.user.dto.request.RegisterRequest;
import com.laxman.shopsphere.user.dto.response.UserResponse;
import com.laxman.shopsphere.user.entity.User;
import com.laxman.shopsphere.user.repository.UserRepository;
import com.laxman.shopsphere.user.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public UserResponse registerUser(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        Role customerRole = roleRepository.findByRoleType(RoleType.CUSTOMER)
                .orElseThrow(() -> new RoleNotFoundException(RoleType.CUSTOMER));

        User user = mapToUser(request, customerRole);
        User savedUser = userRepository.save(user);

        return mapToUserResponse(savedUser);
    }

    private User mapToUser(RegisterRequest request, Role customerRole) {
        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());
        user.setRole(customerRole);

        return user;
    }

    private UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhoneNumber(user.getPhoneNumber());

        return userResponse;
    }
}