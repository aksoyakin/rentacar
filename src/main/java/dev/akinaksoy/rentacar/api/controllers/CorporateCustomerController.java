package dev.akinaksoy.rentacar.api.controllers;

import dev.akinaksoy.rentacar.business.abstracts.CorporateCustomerService;
import dev.akinaksoy.rentacar.business.dtos.requests.corporatecustomer.CreateCorporateCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.corporatecustomer.CreatedCorporateCustomerResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.corporatecustomer.GetAllCorporateCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/corporatecustomers")
public class CorporateCustomerController {
    private CorporateCustomerService corporateCustomerService;

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCorporateCustomerResponse> getAllCorporateCustomer(

    ) {
        return corporateCustomerService.getAllCorporateCustomers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreatedCorporateCustomerResponse createCorporateCustomer(
            CreateCorporateCustomerRequest request
    ) {
        return corporateCustomerService.createCorporateCustomer(request);
    }
}
