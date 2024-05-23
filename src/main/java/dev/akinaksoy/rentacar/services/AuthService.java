package dev.akinaksoy.rentacar.services;

import dev.akinaksoy.rentacar.business.dtos.SignupRequest;
import dev.akinaksoy.rentacar.business.dtos.UserDto;

public interface AuthService {
    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}
