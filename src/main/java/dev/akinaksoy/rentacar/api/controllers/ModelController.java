package dev.akinaksoy.rentacar.api.controllers;

import dev.akinaksoy.rentacar.business.abstracts.ModelService;
import dev.akinaksoy.rentacar.business.dtos.requests.model.CreateModelRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.model.CreatedModelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.model.GetAllModelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.model.GetModelByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelController {
    private ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse createModel(
            @Valid @RequestBody CreateModelRequest request
    ){
        return modelService.createModel(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllModelResponse> getAllModels(

    ){
        return modelService.getAllModels();
    }
    @GetMapping("/{id}")
    public GetModelByIdResponse getModelById(
            @PathVariable int id
    ){
        return modelService.getModelById(id);
    }
}
