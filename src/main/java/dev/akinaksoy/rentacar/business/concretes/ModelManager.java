package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.ModelService;
import dev.akinaksoy.rentacar.business.dtos.requests.model.CreateModelRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.model.CreatedModelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.model.GetAllModelResponse;
import dev.akinaksoy.rentacar.core.utilities.mapping.ModelMapperService;
import dev.akinaksoy.rentacar.dataaccess.abstracts.ModelRepository;
import dev.akinaksoy.rentacar.entities.concretes.Model;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedModelResponse createModel(
            CreateModelRequest request
    ) {
        Model model = this.modelMapperService
                .forRequest()
                .map(request,Model.class);

        model.setCreatedDate(LocalDateTime.now());
        
        this.modelRepository.save(model);

        CreatedModelResponse response = this.modelMapperService
                .forResponse().map(model, CreatedModelResponse.class);

        return response;

    }

    @Override
    public List<GetAllModelResponse> getAllModels(

    ) {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelResponse> modelResponses =
                models.stream().map(model -> modelMapperService
                        .forResponse()
                        .map(model, GetAllModelResponse.class))
                        .collect(Collectors.toList());

        return modelResponses;
    }
}
