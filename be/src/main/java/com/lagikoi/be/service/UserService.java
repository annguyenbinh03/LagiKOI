package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.UserCreationRequest;
import com.lagikoi.be.dto.response.UserResponse;
import com.lagikoi.be.entity.Role;
import com.lagikoi.be.entity.User;
import com.lagikoi.be.entity.UserRole;
import com.lagikoi.be.entity.UserRoleId;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.mapper.UserMapper;
import com.lagikoi.be.repository.RoleRepository;
import com.lagikoi.be.repository.UserRepository;
import com.lagikoi.be.repository.UserRoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserRoleRepository userRoleRepository;
    RoleRepository roleRepository;

    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername((request.getUsername())))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.prepareUserForSave(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        generateRoleForUser(user, userRoleRepository);

        return userMapper.toUserResponse(user);
    }

    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUserInfo(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        UserResponse userResponse = userMapper.toUserResponse(user);
        userResponse.setRoles(userRoleRepository.findRoleNamesByUserId(user.getId()));
        return userResponse;
    }

    public UserResponse getMyInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        UserResponse userResponse = userMapper.toUserResponse(user);
        userResponse.setRoles(userRoleRepository.findRoleNamesByUserId(user.getId()));
        return userResponse;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAllUserInfo() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty())
            throw new AppException(ErrorCode.USER_LIST_EMPTY);
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = userMapper.toUserResponse(user);
            userResponse.setRoles(userRoleRepository.findRoleNamesByUserId(user.getId()));
            userResponses.add(userResponse);
        }
        return userResponses;
    }

    private void generateRoleForUser(User user, UserRoleRepository userRoleRepository) {
        Role roleUser = roleRepository.findRoleByName("USER");
        if(roleUser != null) {
            UserRole userRole = new UserRole();
            UserRoleId userRoleId = new UserRoleId();
            userRoleId.setUserId(user.getId());
            userRoleId.setRoleName(roleUser.getName());
            userRole.setId(userRoleId);
            userRole.setUser(user);
            userRole.setRoleName(roleUser);
            userRoleRepository.save(userRole);
        }else
            throw new AppException(ErrorCode.ROLE_NOT_FOUND);
    }
}
