package dev.akinaksoy.rentacar.business.dtos.requests.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCarRequest {
    private int modelYear;
    private String plate;
    private int state;
    private double dailyPrice;
    private int modelId;
}
