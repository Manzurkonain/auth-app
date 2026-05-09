package com.manzur.auth_app.authentication_app.dtos;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {
    private UUID id;
    private String name;
}