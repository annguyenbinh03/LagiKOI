package com.lagikoi.be.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    String username;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Size(max = 30)
    @Column(name = "first_name", length = 30)
    private String firstName;

    @Size(max = 30)
    @Column(name = "last_name", length = 30)
    private String lastName;

    @Size(max = 15)
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "dob")
    private Instant dob;

}
