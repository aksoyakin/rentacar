package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.TransmissionService;
import dev.akinaksoy.rentacar.business.dtos.requests.transmission.CreateTransmissionRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.GetAllTransmissionResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.GetTransmissionByIdResponse;
import dev.akinaksoy.rentacar.core.utilities.mapping.ModelMapperService;
import dev.akinaksoy.rentacar.dataaccess.abstracts.TransmissionRepository;
import dev.akinaksoy.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedTransmissionResponse createTransmission(
            CreateTransmissionRequest request
    ) {
        Transmission transmission = this.modelMapperService
                .forRequest()
                .map(request,Transmission.class);

        transmission.setCreatedDate(LocalDateTime.now());

        transmissionRepository.save(transmission);

        CreatedTransmissionResponse response = this.modelMapperService
                .forResponse().map(transmission, CreatedTransmissionResponse.class);

        return response;
    }

    @Override
    public List<GetAllTransmissionResponse> getAllTransmissions(

    ) {
        List<Transmission> transmissions = transmissionRepository.findAll();

        List<GetAllTransmissionResponse> transmissionResponses =
                transmissions.stream().map(transmission -> modelMapperService
                        .forResponse()
                        .map(transmission, GetAllTransmissionResponse.class))
                        .collect(Collectors.toList());

        return transmissionResponses;
    }

    @Override
    public GetTransmissionByIdResponse getTransmissionById(
            int id
    ) {
        Transmission transmission = transmissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no transmission for this ID."));

        GetTransmissionByIdResponse response = modelMapperService.forResponse()
                .map(transmission,GetTransmissionByIdResponse.class);

        return response;
    }
}
