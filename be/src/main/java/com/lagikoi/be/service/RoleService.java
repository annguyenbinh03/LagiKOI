package com.lagikoi.be.service;

import com.lagikoi.be.dto.request.RoleCreationRequest;
import com.lagikoi.be.dto.response.RoleResponse;
import com.lagikoi.be.entity.Permission;
import com.lagikoi.be.entity.Role;
import com.lagikoi.be.entity.RolePermission;
import com.lagikoi.be.entity.RolePermissionId;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.mapper.RoleMapper;
import com.lagikoi.be.repository.PermissionRepository;
import com.lagikoi.be.repository.RolePermissionRepository;
import com.lagikoi.be.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RolePermissionRepository rolePermissionRepository;
    RoleMapper roleMapper;

    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public RoleResponse createRole(RoleCreationRequest request) {
        try {
            Role role = roleMapper.prepareRoleForSave(request);
            roleRepository.save(role);

            List<Permission> permissions = permissionRepository.findAllById(request.getPermissions());

            List<RolePermission> rolePermissions = permissions.stream()
                    .map(permission -> {
                        RolePermissionId rolePermissionId = new RolePermissionId();
                        rolePermissionId.setRoleName(role.getName());
                        rolePermissionId.setPermissionName(permission.getName());

                        RolePermission rolePermission = new RolePermission();
                        rolePermission.setId(rolePermissionId);
                        rolePermission.setPermissionName(permission);
                        rolePermission.setRoleName(role);
                        return rolePermission;
                    })
                    .toList();

            rolePermissionRepository.saveAll(rolePermissions);

            Set<String> permissionNames = permissions.stream()
                    .map(Permission::getName)
                    .collect(Collectors.toSet());

            return roleMapper.toRoleResponse(role, permissionNames);
        } catch (DataIntegrityViolationException exception){
            throw new AppException(ErrorCode.ROLE_EXISTED);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<RoleResponse> getAll(){
        List<Role> roles = roleRepository.findAll();
        List<RolePermission> rolePermissions = rolePermissionRepository.findAll();
        Map<Role, Set<String>> roleToPermissionsMap = rolePermissions.stream()
                .collect(Collectors.groupingBy(
                        RolePermission::getRoleName,
                        Collectors.mapping(
                                rp -> rp.getPermissionName().getName(),
                                Collectors.toSet()
                        )
                ));
        return roles.stream()
                .map(role -> {
                    Set<String> permissions = roleToPermissionsMap.getOrDefault(role, Collections.emptySet());
                    return roleMapper.toRoleResponse(role, permissions);
                })
                .toList();
    }

    // TODO: cascade database remove user_roles, role_permissions
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteRole(String roleName) {
        roleRepository.deleteById(roleName);
    }
}
