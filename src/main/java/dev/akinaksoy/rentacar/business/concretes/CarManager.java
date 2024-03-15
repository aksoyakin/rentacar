package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.CarService;
import dev.akinaksoy.rentacar.business.dtos.requests.car.CreateCarRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.car.CreatedCarResponse;
import dev.akinaksoy.rentacar.core.utilities.mapping.ModelMapperService;
import dev.akinaksoy.rentacar.dataaccess.abstracts.CarRepository;
import dev.akinaksoy.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;


    @Override
    public CreatedCarResponse createCar(
            CreateCarRequest request
    ) {
        Car car = this.modelMapperService
                .forRequest()
                .map(request,Car.class);

        car.setCreatedDate(LocalDateTime.now());

        carRepository.save(car);

        CreatedCarResponse response = this.modelMapperService
                .forResponse().map(car, CreatedCarResponse.class);

        return response;
    }
}
