package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.IndividualCustomerService;
import dev.akinaksoy.rentacar.business.dtos.requests.individualcustomer.CreateIndividualCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.individualcustomer.CreatedIndividualCustomerResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.individualcustomer.GetAllIndividualCustomerResponse;
import dev.akinaksoy.rentacar.core.utilities.mapping.ModelMapperService;
import dev.akinaksoy.rentacar.dataaccess.abstracts.IndividualCustomerRepository;
import dev.akinaksoy.rentacar.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {

    private IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService  modelMapperService;
    @Override
    public CreatedIndividualCustomerResponse createIndividualCustomer(
            CreateIndividualCustomerRequest request
    ) {
        IndividualCustomer individualCustomer = this.modelMapperService
                .forRequest()
                .map(request,IndividualCustomer.class);

        individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse response = this.modelMapperService
                .forResponse().map(individualCustomer, CreatedIndividualCustomerResponse.class);

        return response;
    }

    @Override
    public List<GetAllIndividualCustomerResponse> getAllIndividualCustomer(

    ) {
        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();

        List<GetAllIndividualCustomerResponse> individualCustomerResponses =
                individualCustomers.stream().map(individualCustomer -> modelMapperService
                        .forResponse()
                        .map(individualCustomer, GetAllIndividualCustomerResponse.class))
                        .collect(Collectors.toList());

        return individualCustomerResponses;

    }
}
