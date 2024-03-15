package dev.akinaksoy.rentacar.business.abstracts;


import dev.akinaksoy.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.GetAllBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse createBrand(
            CreateBrandRequest request
    );
    List<GetAllBrandResponse> getAllBrands(

    );
}
