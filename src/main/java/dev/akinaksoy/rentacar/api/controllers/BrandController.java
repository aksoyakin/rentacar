package dev.akinaksoy.rentacar.api.controllers;

import dev.akinaksoy.rentacar.business.abstracts.BrandService;
import dev.akinaksoy.rentacar.business.dtos.requests.CreateBrandRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.CreatedBrandResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.GetAllBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandController {
    private BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse createBrand(
            @Valid @RequestBody CreateBrandRequest request
    ){
        return brandService.createBrand(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAll(

    ){
        return brandService.getAllBrands();
    }
}
