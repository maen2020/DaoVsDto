package com.maen.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO de la entidad UserEntity.
// La teoria dice que nose debe usar @Data con una entidad.
@Data // Trae diferentes anotaciones (@Getter, @Setter, ToString, Builder, etc.)
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private byte age;
}
