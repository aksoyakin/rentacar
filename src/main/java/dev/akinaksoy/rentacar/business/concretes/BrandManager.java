package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.BrandService;
import dev.akinaksoy.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.CreatedBrandResponse;

import dev.akinaksoy.rentacar.business.dtos.responses.brand.GetAllBrandResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.brand.GetBrandByIdResponse;
import dev.akinaksoy.rentacar.core.utilities.mapping.ModelMapperService;
import dev.akinaksoy.rentacar.dataaccess.abstracts.BrandRepository;
import dev.akinaksoy.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;


    @Override
    public CreatedBrandResponse createBrand(
            CreateBrandRequest request
    ) {
        Brand brand = this.modelMapperService
                .forRequest()
                .map(request,Brand.class);

        brand.setCreatedDate(LocalDateTime.now());

        brandRepository.save(brand);

        CreatedBrandResponse response = this.modelMapperService
                .forResponse().map(brand, CreatedBrandResponse.class);

        return response;
    }

    @Override
    public List<GetAllBrandResponse> getAllBrands(

    ) {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponse> brandResponses =
                brands.stream().map(brand -> modelMapperService
                                .forResponse()
                                .map(brand, GetAllBrandResponse.class))
                                .collect(Collectors.toList());

        return brandResponses;
    }

    @Override
    public GetBrandByIdResponse getBrandById(
            int id
    ) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no brand for this ID."));

        GetBrandByIdResponse response = modelMapperService.forResponse()
                .map(brand, GetBrandByIdResponse.class);

        return response;
    }
}
