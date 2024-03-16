package dev.akinaksoy.rentacar.api.controllers;

import dev.akinaksoy.rentacar.business.abstracts.TransmissionService;
import dev.akinaksoy.rentacar.business.dtos.requests.transmission.CreateTransmissionRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.GetAllTransmissionResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.transmission.GetTransmissionByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/trasmissions")
public class TransmissionController {
    private TransmissionService transmissionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTransmissionResponse createTransmission(
            @RequestBody CreateTransmissionRequest request
    ){
        return transmissionService.createTransmission(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllTransmissionResponse> getAllTransmissions(

    ){
        return transmissionService.getAllTransmissions();
    }
    @GetMapping("/{id}")
    public GetTransmissionByIdResponse getTransmissionById(
            @PathVariable int id
    ) {
        return transmissionService.getTransmissionById(id);
    }
}
