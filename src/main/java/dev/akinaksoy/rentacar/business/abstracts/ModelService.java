package dev.akinaksoy.rentacar.business.abstracts;

import dev.akinaksoy.rentacar.business.dtos.requests.model.CreateModelRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.model.CreatedModelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.model.GetAllModelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.model.GetModelByIdResponse;

import java.util.List;

public interface ModelService {
    CreatedModelResponse createModel(
            CreateModelRequest request
    );
    List<GetAllModelResponse> getAllModels(

    );
    GetModelByIdResponse getModelById(
            int id
    );
}
