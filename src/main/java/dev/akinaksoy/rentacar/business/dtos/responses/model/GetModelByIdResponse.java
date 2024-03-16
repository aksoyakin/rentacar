package dev.akinaksoy.rentacar.business.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelByIdResponse {
    private int id;
    private String name;
    private int brandId;
    private  int fuelId;
    private int transmissionId;
}
