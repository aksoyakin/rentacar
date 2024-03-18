package dev.akinaksoy.rentacar.business.abstracts;

import dev.akinaksoy.rentacar.business.dtos.requests.transmission.CreateTransmissionRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.model.CreatedModelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.GetAllTransmissionResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.GetTransmissionByIdResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.UpdateTransmissionResponse;

import java.util.List;

public interface TransmissionService {

    CreatedTransmissionResponse createTransmission(
            CreateTransmissionRequest request
    );

    List<GetAllTransmissionResponse> getAllTransmissions(

    );
    GetTransmissionByIdResponse getTransmissionById(
            int id
    );
    UpdateTransmissionResponse updateTransmissionById(
            UpdateTransmissionRequest request,
            int id
    );


}
