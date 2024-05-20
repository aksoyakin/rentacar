package dev.akinaksoy.rentacar.business.abstracts;

import dev.akinaksoy.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.customer.CreatedCustomerResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.customer.GetAllCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomerResponse> getAllCustomers();

    CreatedCustomerResponse createCustomer(
            CreateCustomerRequest request
    );

}
