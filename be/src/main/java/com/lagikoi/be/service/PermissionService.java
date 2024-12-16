package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.PermissionCreationRequest;
import com.lagikoi.be.dto.response.PermissionResponse;
import com.lagikoi.be.entity.Permission;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.mapper.PermissionMapper;
import com.lagikoi.be.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public PermissionResponse createPermission(PermissionCreationRequest request) {
        if(permissionRepository.existsById(request.getName()))
            throw new AppException(ErrorCode.PERMISSION_EXISTED);
        Permission permission = permissionMapper.preparePermissionForSave(request);
        permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<PermissionResponse> getAll(){
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deletePermission(String name) {
        permissionRepository.deleteById(name);
    }
}
