package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.BrandService;
import dev.akinaksoy.rentacar.business.dtos.requests.CreateBrandRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.CreatedBrandResponse;

import dev.akinaksoy.rentacar.business.dtos.responses.GetAllBrandResponse;
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

        Brand createdBrand = this.brandRepository.save(brand);

        CreatedBrandResponse response = this.modelMapperService
                .forResponse().map(brand, CreatedBrandResponse.class);

        return response;



        /*
        MANUEL MAPPING!

        Brand brand = new Brand();
        brand.setName(request.getName());
        brand.setCreatedDate(LocalDateTime.now());
        this.brandRepository.save(brand);

        return brand;
         */
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
}
