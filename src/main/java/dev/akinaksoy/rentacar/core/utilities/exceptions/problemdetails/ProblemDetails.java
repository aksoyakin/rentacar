package dev.akinaksoy.rentacar.core.utilities.exceptions.problemdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProblemDetails {
    //rfce standarts
    private String title;
    private String detail;
    private String status;
    private String type;
}
