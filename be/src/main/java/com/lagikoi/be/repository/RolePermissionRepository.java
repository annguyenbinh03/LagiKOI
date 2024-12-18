package com.lagikoi.be.repository;

import com.lagikoi.be.entity.Role;
import com.lagikoi.be.entity.RolePermission;
import com.lagikoi.be.entity.RolePermissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionId> {
    @Query("SELECT DISTINCT  rp.permissionName.name " +
            "FROM RolePermission rp " +
            "WHERE rp.roleName.name IN :roleIds")
    Set<String> getPermissionsNameByRoleIds(@Param("roleIds") List<String> roleIds);
    @Query("SELECT rp.permissionName.name FROM RolePermission rp WHERE rp.roleName.name = :roleId")
    Set<String> findPermissionsByRoleId(@Param("roleId") String roleId);
    void deleteByRoleName(Role roleName);
}
