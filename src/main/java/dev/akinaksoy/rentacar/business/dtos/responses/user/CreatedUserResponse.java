package dev.akinaksoy.rentacar.business.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedUserResponse {
    String firstName;
    String lastName;
    String email;
    String phone;
    String username;
    String password;
}
