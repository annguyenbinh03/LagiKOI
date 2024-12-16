package com.lagikoi.be.controller;

import com.lagikoi.be.dto.request.PermissionCreationRequest;
import com.lagikoi.be.dto.request.RoleCreationRequest;
import com.lagikoi.be.dto.response.ApiResponse;
import com.lagikoi.be.dto.response.PermissionResponse;
import com.lagikoi.be.dto.response.RoleResponse;
import com.lagikoi.be.service.PermissionService;
import com.lagikoi.be.service.RoleService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;

    @PostMapping("/create")
    public ApiResponse<RoleResponse> createRole(@RequestBody @Valid RoleCreationRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.createRole(request))
                .build();
    }

    @GetMapping("/all")
    public ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    public ApiResponse<Void> deleteRole(@PathVariable("role") String role) {
        roleService.deleteRole(role);
        return ApiResponse.<Void>builder()
                .build();
    }
}
