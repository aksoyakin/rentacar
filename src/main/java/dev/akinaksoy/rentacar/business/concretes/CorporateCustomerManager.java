package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.CorporateCustomerService;
import dev.akinaksoy.rentacar.business.dtos.requests.corporatecustomer.CreateCorporateCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.corporatecustomer.CreatedCorporateCustomerResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.corporatecustomer.GetAllCorporateCustomerResponse;
import dev.akinaksoy.rentacar.core.utilities.mapping.ModelMapperService;
import dev.akinaksoy.rentacar.dataaccess.abstracts.CorporateCustomerRepository;
import dev.akinaksoy.rentacar.entities.concretes.CorporateCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {

    private CorporateCustomerRepository corporateCustomerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedCorporateCustomerResponse createCorporateCustomer(
            CreateCorporateCustomerRequest request
    ) {
        CorporateCustomer corporateCustomer = this.modelMapperService
                .forRequest()
                .map(request,CorporateCustomer.class);

        corporateCustomerRepository.save(corporateCustomer);

        CreatedCorporateCustomerResponse response = this.modelMapperService
                .forResponse().map(corporateCustomer, CreatedCorporateCustomerResponse.class);

        return response;
    }

    @Override
    public List<GetAllCorporateCustomerResponse> getAllCorporateCustomers(

    ) {
        List<CorporateCustomer> corporateCustomers = corporateCustomerRepository.findAll();

        List<GetAllCorporateCustomerResponse> corporateCustomerResponses =
                corporateCustomers.stream().map(corporateCustomer -> modelMapperService
                        .forResponse()
                        .map(corporateCustomer, GetAllCorporateCustomerResponse.class))
                        .collect(Collectors.toList());

        return corporateCustomerResponses;
    }
}
