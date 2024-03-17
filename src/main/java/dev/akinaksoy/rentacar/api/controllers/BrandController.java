package dev.akinaksoy.rentacar.api.controllers;

import dev.akinaksoy.rentacar.business.abstracts.BrandService;
import dev.akinaksoy.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.GetAllBrandResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.GetBrandByIdResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.UpdateBrandResponse;
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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAllBrands(

    ){
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public GetBrandByIdResponse getBrandById(
            @PathVariable int id
    ){
        return brandService.getBrandById(id);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse updateBrandById(
            @RequestBody UpdateBrandRequest request,
            @PathVariable int id
    ) {
        return brandService.updateBrandById(request,id);
    }
}
