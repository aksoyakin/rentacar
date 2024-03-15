package dev.akinaksoy.rentacar.business.dtos.responses.transmission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetAllTransmissionResponse {
    private int id;
    private String name;
}
