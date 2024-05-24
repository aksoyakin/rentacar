package dev.akinaksoy.rentacar.business.dtos;

import dev.akinaksoy.rentacar.entities.concretes.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;

}
