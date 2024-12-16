package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.RoleCreationRequest;
import com.lagikoi.be.dto.response.RoleResponse;
import com.lagikoi.be.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role prepareRoleForSave(RoleCreationRequest request);
    @Mapping(source = "permissions", target = "permissions")
    RoleResponse toRoleResponse(Role role, Set<String> permissions);
}
