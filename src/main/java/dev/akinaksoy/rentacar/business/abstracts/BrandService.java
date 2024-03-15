package dev.akinaksoy.rentacar.business.abstracts;


import dev.akinaksoy.rentacar.business.dtos.requests.CreateBrandRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.CreatedBrandResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.GetAllBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse createBrand(
            CreateBrandRequest request
    );
    List<GetAllBrandResponse> getAllBrands(

    );
}
