package dev.akinaksoy.rentacar.core.utilities.exceptions.problemdetails;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
public class ValidationProblemDetails extends ProblemDetails{
    public ValidationProblemDetails(

    ){
        setTitle("Validation Rule Violation");
        setDetail("Validation Problems");
        setType("https://akinaksoy.dev/exceptions/validation");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
    private Map<String,String> errors;

}
