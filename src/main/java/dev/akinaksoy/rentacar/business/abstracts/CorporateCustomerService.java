package dev.akinaksoy.rentacar.business.abstracts;

import dev.akinaksoy.rentacar.business.dtos.requests.corporatecustomer.CreateCorporateCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.corporatecustomer.CreatedCorporateCustomerResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.corporatecustomer.GetAllCorporateCustomerResponse;

import java.util.List;

public interface CorporateCustomerService {

    CreatedCorporateCustomerResponse createCorporateCustomer(
            CreateCorporateCustomerRequest request
    );
    List<GetAllCorporateCustomerResponse> getAllCorporateCustomers(

    );
}
