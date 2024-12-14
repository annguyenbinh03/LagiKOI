package com.lagikoi.be.configuration;

import com.lagikoi.be.entity.Role;
import com.lagikoi.be.entity.User;
import com.lagikoi.be.entity.UserRole;
import com.lagikoi.be.entity.UserRoleId;
import com.lagikoi.be.exception.AppException;
import com.lagikoi.be.exception.ErrorCode;
import com.lagikoi.be.repository.RoleRepository;
import com.lagikoi.be.repository.UserRepository;
import com.lagikoi.be.repository.UserRoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        return args -> {
            if(userRepository.findByUsername("admin").isEmpty()) {
                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin"));
                user.setIsDeleted(false);
                userRepository.save(user);
                Role roleUser = roleRepository.findRoleByName("ADMIN");
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
                log.warn("admin user has been created with default password: admin");
            }
        };
    }
}
