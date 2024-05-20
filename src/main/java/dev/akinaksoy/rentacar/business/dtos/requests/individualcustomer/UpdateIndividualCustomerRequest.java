package dev.akinaksoy.rentacar.business.dtos.requests.individualcustomer;

import dev.akinaksoy.rentacar.entities.concretes.enums.CustomerType;
import dev.akinaksoy.rentacar.entities.concretes.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerRequest {
    private int id;
    private String nationalId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String userName;
    private String password;
    private Set<Role> authorities = Set.of(Role.ROLE_CUSTOMER);
    private CustomerType customerType = CustomerType.INDIVIDUAL_CUSTOMER;
}
