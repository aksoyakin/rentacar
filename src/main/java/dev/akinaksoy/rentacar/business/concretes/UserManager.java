package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.UserService;
import dev.akinaksoy.rentacar.business.dtos.requests.user.CreateUserRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.user.CreatedUserResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.user.GetAllUserResponse;
import dev.akinaksoy.rentacar.core.utilities.mapping.ModelMapperService;
import dev.akinaksoy.rentacar.dataaccess.abstracts.UserRepository;
import dev.akinaksoy.rentacar.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedUserResponse createUser(
            CreateUserRequest request
    ) {
        User user = this.modelMapperService
                .forRequest()
                .map(request,User.class);

        userRepository.save(user);

        CreatedUserResponse response = this.modelMapperService
                .forResponse().map(user,CreatedUserResponse.class);

        return response;
    }

    @Override
    public List<GetAllUserResponse> getAllUsers(

    ) {
        List<User> users = userRepository.findAll();

        List<GetAllUserResponse> userResponses =
                users.stream().map(user -> modelMapperService
                        .forResponse()
                        .map(user, GetAllUserResponse.class))
                        .collect(Collectors.toList());

        return userResponses;
    }
}
