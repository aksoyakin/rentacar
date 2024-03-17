package dev.akinaksoy.rentacar.business.abstracts;


import dev.akinaksoy.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.GetAllBrandResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.GetBrandByIdResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse createBrand(
            CreateBrandRequest request
    );
    List<GetAllBrandResponse> getAllBrands(

    );
    GetBrandByIdResponse getBrandById(
            int id
    );
    UpdateBrandResponse updateBrandById(
            UpdateBrandRequest request,
            int id
    );
}
