package dev.akinaksoy.rentacar.core.utilities.exceptions.problemdetails;

import org.springframework.http.HttpStatus;

public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails(

    ){
        setTitle("Business Rule Violation");
        setType("https://akinaksoy.dev/exception/business");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }

}
