package dev.akinaksoy.rentacar.api.controllers;

import dev.akinaksoy.rentacar.business.abstracts.IndividualCustomerService;
import dev.akinaksoy.rentacar.business.dtos.requests.individualcustomer.CreateIndividualCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.individualcustomer.CreatedIndividualCustomerResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.individualcustomer.GetAllIndividualCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/individualcustomers")
public class IndividualCustomerController {

    private IndividualCustomerService individualCustomerService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreatedIndividualCustomerResponse createIndividualCustomer(
            @RequestBody CreateIndividualCustomerRequest request
    ) {
        return individualCustomerService.createIndividualCustomer(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllIndividualCustomerResponse> getAllIndividualCustomers(

    ){
        return individualCustomerService.getAllIndividualCustomer();
    }


}
