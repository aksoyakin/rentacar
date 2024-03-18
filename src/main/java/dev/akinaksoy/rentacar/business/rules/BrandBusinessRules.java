package dev.akinaksoy.rentacar.business.rules;

import dev.akinaksoy.rentacar.core.utilities.exceptions.types.BusinessException;
import dev.akinaksoy.rentacar.dataaccess.abstracts.BrandRepository;
import dev.akinaksoy.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    BrandRepository brandRepository;
    public void brandNameCanNotBeDuplicated(
            String brandName
    ){
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);
        if(brand.isPresent()){
            throw new BusinessException("Brand name already exist!");
        }
    }
}
