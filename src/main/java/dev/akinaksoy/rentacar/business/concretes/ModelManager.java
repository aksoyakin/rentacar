package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.ModelService;
import dev.akinaksoy.rentacar.business.dtos.requests.model.CreateModelRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.model.UpdateModelRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.model.CreatedModelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.model.GetAllModelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.model.GetModelByIdResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.model.UpdateModelResponse;
import dev.akinaksoy.rentacar.business.rules.ModelBusinessRules;
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
    private ModelBusinessRules modelBusinessRules;

    @Override
    public CreatedModelResponse createModel(
            CreateModelRequest request
    ) {
        modelBusinessRules.modelNameCanNotBeDuplicated(request.getName());


        Model model = this.modelMapperService
                .forRequest()
                .map(request,Model.class);

//        model.setId(0);
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

    @Override
    public GetModelByIdResponse getModelById(
            int id
    ) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for this ID."));

        GetModelByIdResponse response = modelMapperService.forResponse()
                .map(model, GetModelByIdResponse.class);

        return  response;
    }

    @Override
    public UpdateModelResponse updateModelById(
            UpdateModelRequest request,
            int id
    ) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for this id."));

        Model updatedModel = modelMapperService.forRequest()
                .map(request,Model.class);

        model.setId(id);
        model.setCreatedDate(LocalDateTime.now());

        model.setName(updatedModel.getName() != null ? updatedModel.getName() : model.getName());

        modelRepository.save(model);

        UpdateModelResponse response = modelMapperService.forResponse()
                .map(model,UpdateModelResponse.class);

        return response;

    }
}
