package dev.akinaksoy.rentacar.business.abstracts;

import dev.akinaksoy.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import dev.akinaksoy.rentacar.business.dtos.requests.fuel.UpdateFuelRequest;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.GetAllFuelResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.GetFuelByIdResponse;
import dev.akinaksoy.rentacar.business.dtos.responses.fuel.UpdateFuelResponse;

import java.util.List;

public interface FuelService {
    CreatedFuelResponse createFuel(
            CreateFuelRequest request
    );
    List<GetAllFuelResponse> getAllFuels(

    );
    GetFuelByIdResponse getFuelById(
            int id
    );
    UpdateFuelResponse updateFuelById(
            UpdateFuelRequest request,
            int id
    );

}
