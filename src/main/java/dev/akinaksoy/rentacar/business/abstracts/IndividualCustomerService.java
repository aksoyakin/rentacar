package dev.akinaksoy.rentacar.business.abstracts;

import dev.akinaksoy.rentacar.business.dtos.requests.individualcustomer.CreateIndividualCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.individualcustomer.CreatedIndividualCustomerResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.individualcustomer.GetAllIndividualCustomerResponse;

import java.util.List;

public interface IndividualCustomerService {

    CreatedIndividualCustomerResponse createIndividualCustomer(
            CreateIndividualCustomerRequest request
    );

    List<GetAllIndividualCustomerResponse> getAllIndividualCustomer(

    );


}
