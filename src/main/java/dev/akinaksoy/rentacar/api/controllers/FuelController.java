package dev.akinaksoy.rentacar.api.controllers;

import dev.akinaksoy.rentacar.business.abstracts.FuelService;
import dev.akinaksoy.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fuels")
public class FuelController {
    private FuelService fuelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedFuelResponse createFuel(
            @Valid @RequestBody CreateFuelRequest request
    ){
        return fuelService.createFuel(request);
    }
}