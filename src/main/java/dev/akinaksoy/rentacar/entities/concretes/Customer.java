package dev.akinaksoy.rentacar.entities.concretes;


import dev.akinaksoy.rentacar.entities.concretes.enums.CustomerType;
import dev.akinaksoy.rentacar.entities.concretes.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer extends User {

    Set<Role> authorities = Set.of(Role.ROLE_CUSTOMER);

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type")
    private CustomerType customerType;


}
