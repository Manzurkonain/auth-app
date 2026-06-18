package com.manzur.auth_app.authentication_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manzur.auth_app.authentication_app.entities.Provider;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private UUID id;
    private String email;
    private String name;
    private String password;
    private String image;

    // FIX: This stops Lombok from making a duplicate 'getEnable()' method
    @Getter(AccessLevel.NONE)
    private Boolean enable;

    // This is perfect! Jackson and your code will use this safely.
    public boolean isEnable() {
        return this.enable != null && this.enable;
    }

    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();
    private Provider provider = Provider.LOCAL;
    private Set<RoleDTO> roles = new HashSet<>();
}
