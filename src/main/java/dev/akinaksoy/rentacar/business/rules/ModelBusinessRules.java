package dev.akinaksoy.rentacar.business.rules;

import dev.akinaksoy.rentacar.business.dtos.requests.model.CreateModelRequest;
import dev.akinaksoy.rentacar.core.utilities.exceptions.types.BusinessException;
import dev.akinaksoy.rentacar.dataaccess.abstracts.ModelRepository;
import dev.akinaksoy.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    ModelRepository modelRepository;

    public void modelNameCanNotBeDuplicated(
            String modelName
    ){
        Optional<Model> model = modelRepository.findByNameIgnoreCase(modelName);
        if(model.isPresent()){
            throw new BusinessException("Model name already exist!");
        }
    }

}
