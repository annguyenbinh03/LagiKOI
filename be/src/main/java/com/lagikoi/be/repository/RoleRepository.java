package com.lagikoi.be.repository;

import com.lagikoi.be.entity.Role;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findRoleByName(@Size(max = 50) String name);
}
