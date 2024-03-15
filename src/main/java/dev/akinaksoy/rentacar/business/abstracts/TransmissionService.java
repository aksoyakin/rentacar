package dev.akinaksoy.rentacar.business.abstracts;

import dev.akinaksoy.rentacar.business.dtos.requests.transmission.CreateTransmissionRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.model.CreatedModelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;

public interface TransmissionService {

    CreatedTransmissionResponse createTransmission(
            CreateTransmissionRequest request
    );


}
