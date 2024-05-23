package dev.akinaksoy.rentacar.business.dtos;

import dev.akinaksoy.rentacar.entities.concretes.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}
