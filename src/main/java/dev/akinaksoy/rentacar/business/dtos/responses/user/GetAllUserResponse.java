package dev.akinaksoy.rentacar.business.dtos.responses.user;

import dev.akinaksoy.rentacar.entities.concretes.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Role> authorities;
}
