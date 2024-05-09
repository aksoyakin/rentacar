package dev.akinaksoy.rentacar.api.controllers;

import dev.akinaksoy.rentacar.business.abstracts.CarService;
import dev.akinaksoy.rentacar.business.dtos.requests.car.CreateCarRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.car.UpdateCarRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.car.CreatedCarResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.car.GetAllCarResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.car.GetCarByIdResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.car.UpdateCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarController {
    private CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse createCar(
            @RequestBody @Valid CreateCarRequest request
    ){
        return carService.createCar(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCarResponse> getAllCars(

    ){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public GetCarByIdResponse getCarById(
            @PathVariable int id
    ){
        return carService.getCarById(id);
    }

    @PutMapping("{id}")
    public UpdateCarResponse updateCarById(
            @RequestBody UpdateCarRequest request,
            @PathVariable int id
    ){
        return carService.updateCarById(request,id);
    }
    @DeleteMapping("{id}")
    void deleteCarById(
            @PathVariable int id
    ){
        carService.deleteCarById(id);
    }
}
