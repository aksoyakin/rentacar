package dev.akinaksoy.rentacar.business.abstracts;

import dev.akinaksoy.rentacar.business.dtos.requests.user.CreateUserRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.user.CreatedUserResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.user.GetAllUserResponse;

import java.util.List;

public interface UserService {

    CreatedUserResponse createUser(
            CreateUserRequest request
    );
    List<GetAllUserResponse> getAllUsers(

    );
}
