package dev.akinaksoy.rentacar.business.dtos.responses.fuel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedFuelResponse {
    private  int id;
    private String name;
}
