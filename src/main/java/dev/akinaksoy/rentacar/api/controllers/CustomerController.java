package dev.akinaksoy.rentacar.api.controllers;

import dev.akinaksoy.rentacar.business.abstracts.CustomerService;
import dev.akinaksoy.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.customer.CreatedCustomerResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.customer.GetAllCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {

    private CustomerService customerService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreatedCustomerResponse createCustomer(
            @RequestBody CreateCustomerRequest request
    ) {
        return customerService.createCustomer(request);
    }

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCustomerResponse> getAllCustomes(

    ) {
        return customerService.getAllCustomers();
    }


}
