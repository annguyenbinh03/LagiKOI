package com.lagikoi.be.mapper;

import com.lagikoi.be.dto.request.PermissionCreationRequest;
import com.lagikoi.be.dto.response.PermissionResponse;
import com.lagikoi.be.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission preparePermissionForSave(PermissionCreationRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
