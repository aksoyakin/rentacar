package dev.akinaksoy.rentacar.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCustomerResponse {
    private String customerNumber;
}
