package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.CustomerService;
import dev.akinaksoy.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.customer.CreatedCustomerResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.customer.GetAllCustomerResponse;
import dev.akinaksoy.rentacar.core.utilities.mapping.ModelMapperService;
import dev.akinaksoy.rentacar.dataaccess.abstracts.CustomerRepository;
import dev.akinaksoy.rentacar.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllCustomerResponse> getAllCustomers(

    ) {
        List<Customer> customers = customerRepository.findAll();

        List<GetAllCustomerResponse> customerResponses =
                customers.stream().map(customer -> modelMapperService
                                .forResponse()
                                .map(customer, GetAllCustomerResponse.class))
                                .collect(Collectors.toList());

        return customerResponses;
    }

    @Override
    public CreatedCustomerResponse createCustomer(
            CreateCustomerRequest request
    ) {
        Customer customer = this.modelMapperService
                .forRequest()
                .map(request,Customer.class);

        customerRepository.save(customer);

        CreatedCustomerResponse response = this.modelMapperService
                .forResponse().map(customer, CreatedCustomerResponse.class);

        return response;
    }


}
