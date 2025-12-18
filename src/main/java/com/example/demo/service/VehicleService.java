                                                                                                                                                                                                    package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Vehicle;

public interface VehicleService {

    Vehicle insertVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Optional<Vehicle> getOneVehicle(Long id);

    void deleteVehicle(Long id);
}