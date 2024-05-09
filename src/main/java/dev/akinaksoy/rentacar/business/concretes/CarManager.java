package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.CarService;
import dev.akinaksoy.rentacar.business.dtos.requests.car.CreateCarRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.car.UpdateCarRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.car.CreatedCarResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.car.GetAllCarResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.car.GetCarByIdResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.car.UpdateCarResponse;
import dev.akinaksoy.rentacar.business.rules.CarBusinessRules;
import dev.akinaksoy.rentacar.core.utilities.mapping.ModelMapperService;
import dev.akinaksoy.rentacar.dataaccess.abstracts.CarRepository;
import dev.akinaksoy.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;


    @Override
    public CreatedCarResponse createCar(
            CreateCarRequest request
    ) {
        carBusinessRules.plateCanNotBeDuplicated(request.getPlate());

        Car car = this.modelMapperService
                .forRequest()
                .map(request,Car.class);

        car.setCreatedDate(LocalDateTime.now());

//        car.setId(0);
        carRepository.save(car);

        CreatedCarResponse response = this.modelMapperService
                .forResponse().map(car, CreatedCarResponse.class);

        return response;
    }

    @Override
    public List<GetAllCarResponse> getAllCars(

    ) {
        List<Car> cars = carRepository.findAll();

        List<GetAllCarResponse> carResponses =
                cars.stream().map(car -> modelMapperService
                        .forResponse()
                        .map(car, GetAllCarResponse.class))
                        .collect(Collectors.toList());

        return carResponses;
    }

    @Override
    public GetCarByIdResponse getCarById(
            int id
    ) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There no car for this ID."));

        GetCarByIdResponse response = modelMapperService.forResponse()
                .map(car,GetCarByIdResponse.class);

        return response;
    }

    @Override
    public UpdateCarResponse updateCarById(
            UpdateCarRequest request,
            int id
    ) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no car for this ID."));

        Car updatedCar = modelMapperService.forRequest()
                .map(request,Car.class);

        car.setId(id);
        car.setUpdatedDate(LocalDateTime.now());

        car.setPlate(updatedCar.getPlate());
        car.setState(updatedCar.getState());
        car.setDailyPrice(updatedCar.getDailyPrice());

        carRepository.save(car);

        UpdateCarResponse response = modelMapperService.forResponse()
                .map(car,UpdateCarResponse.class);

        return response;

    }

    @Override
    public void deleteCarById(
            int id
    ) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no car for this ID."));
        car.setDeletedDate(LocalDateTime.now());
        carRepository.deleteById(id);
    }
}
