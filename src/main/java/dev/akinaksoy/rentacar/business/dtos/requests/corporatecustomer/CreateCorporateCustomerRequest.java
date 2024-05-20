package dev.akinaksoy.rentacar.business.dtos.requests.corporatecustomer;

import dev.akinaksoy.rentacar.entities.concretes.enums.CustomerType;
import dev.akinaksoy.rentacar.entities.concretes.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCorporateCustomerRequest {
    private String email;
    private String phone;
    private String username;
    private String password;
    private String companyName;
    private String vatNumber;
    private Set<Role> authorities = Set.of(Role.ROLE_CUSTOMER);
    private CustomerType customerType = CustomerType.CORPORATE_CUSTOMER;
}
