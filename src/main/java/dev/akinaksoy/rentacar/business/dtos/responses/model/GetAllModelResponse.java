package dev.akinaksoy.rentacar.business.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetAllModelResponse {
    private int id;
    private String name;
    private int brandId;
    private  int fuelId;
    private int transmissionId;
}
