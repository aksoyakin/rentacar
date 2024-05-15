package dev.akinaksoy.rentacar.api.controllers;

import dev.akinaksoy.rentacar.business.abstracts.FuelService;
import dev.akinaksoy.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.fuel.UpdateFuelRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.GetAllFuelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.GetFuelByIdResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.UpdateFuelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllFuelResponse> getAllFuels(

    ){
        return fuelService.getAllFuels();
    }

    @GetMapping("/{id}")
    public GetFuelByIdResponse getFuelById(
            @PathVariable int id
    ){
        return fuelService.getFuelById(id);
    }
    @PutMapping("/{id}")
    public UpdateFuelResponse updateFuelById(
            @RequestBody UpdateFuelRequest request,
            @PathVariable int id
    ){
        return fuelService.updateFuelById(request,id);
    }


}
