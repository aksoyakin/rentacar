package dev.akinaksoy.rentacar.business.dtos.requests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateModelRequest {
    private String name;
    private int brandId;
    private int fuelId;
    private int transmissionId;
}
