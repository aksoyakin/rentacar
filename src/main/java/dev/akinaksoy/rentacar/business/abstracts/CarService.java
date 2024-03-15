package dev.akinaksoy.rentacar.business.abstracts;



import dev.akinaksoy.rentacar.business.dtos.requests.car.CreateCarRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.car.CreatedCarResponse;

public interface CarService {
    CreatedCarResponse createCar(
            CreateCarRequest request
    );
}
