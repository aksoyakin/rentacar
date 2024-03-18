package dev.akinaksoy.rentacar.business.rules;

import dev.akinaksoy.rentacar.core.utilities.exceptions.types.BusinessException;
import dev.akinaksoy.rentacar.dataaccess.abstracts.CarRepository;
import dev.akinaksoy.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    CarRepository carRepository;
    public void plateCanNotBeDuplicated(
            String plate
    ){
        boolean isPlateExist = carRepository.existsByPlate(plate);
        if(isPlateExist){
            throw new BusinessException("Plate already exist!");
        }
    }

}
