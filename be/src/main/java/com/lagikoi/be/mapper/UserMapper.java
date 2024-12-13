package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.UserCreationRequest;
import com.lagikoi.be.dto.response.UserResponse;
import com.lagikoi.be.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "isDeleted", constant = "false")
    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    User prepareUserForSave(UserCreationRequest request);

    UserResponse toUserResponse(User user);
}
