package dev.akinaksoy.rentacar.business.concretes;

import dev.akinaksoy.rentacar.business.abstracts.FuelService;
import dev.akinaksoy.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.GetAllFuelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.GetFuelByIdResponse;
import dev.akinaksoy.rentacar.core.utilities.mapping.ModelMapperService;
import dev.akinaksoy.rentacar.dataaccess.abstracts.FuelRepository;
import dev.akinaksoy.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedFuelResponse createFuel(
            CreateFuelRequest request
    ) {
        Fuel fuel = this.modelMapperService
                .forRequest()
                .map(request,Fuel.class);

        fuel.setCreatedDate(LocalDateTime.now());

        fuelRepository.save(fuel);

        CreatedFuelResponse response = this.modelMapperService
                .forResponse().map(fuel, CreatedFuelResponse.class);

        return response;
    }

    @Override
    public List<GetAllFuelResponse> getAllFuels(

    ) {
        List<Fuel> fuels = fuelRepository.findAll();

        List<GetAllFuelResponse> fuelResponses =
                fuels.stream().map(fuel -> modelMapperService
                        .forResponse()
                        .map(fuel, GetAllFuelResponse.class))
                        .collect(Collectors.toList());

        return fuelResponses;
    }

    @Override
    public GetFuelByIdResponse getFuelById(
            int id
    ) {
        Fuel fuel = fuelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no fuel for this ID"));

        GetFuelByIdResponse response = modelMapperService.forResponse()
                .map(fuel,GetFuelByIdResponse.class);

        return response;
    }
}
