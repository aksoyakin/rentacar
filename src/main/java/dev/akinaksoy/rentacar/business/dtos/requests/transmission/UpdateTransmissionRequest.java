package dev.akinaksoy.rentacar.business.dtos.requests.transmission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTransmissionRequest {
    private String name;
}
