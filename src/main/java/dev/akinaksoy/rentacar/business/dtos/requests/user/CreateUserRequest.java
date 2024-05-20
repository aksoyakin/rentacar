package dev.akinaksoy.rentacar.business.dtos.requests.user;


import dev.akinaksoy.rentacar.entities.concretes.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserRequest {
    String firstName;
    String lastName;
    String email;
    String phone;
    String username;
    String password;
    Set<Role> authorities;
}
