package com.lagikoi.be.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleCreationRequest {
    @NotBlank
    @Size(max = 50)
    String name;
    @Size(max = 255)
    String description;
    Set<String> permissions;
}
