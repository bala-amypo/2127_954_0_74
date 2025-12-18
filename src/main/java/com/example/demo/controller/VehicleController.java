package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.insertVehicle(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleService.getOneVehicle(id);
    }

    @PutMapping("/{id}")
    public String updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> vehicleOpt = vehicleService.getOneVehicle(id);

        if (vehicleOpt.isPresent()) {
            Vehicle existingVehicle = vehicleOpt.get();
            existingVehicle.setBrand(vehicle.getBrand());
            existingVehicle.setModel(vehicle.getModel());
            existingVehicle.setNumber(vehicle.getNumber());
            existingVehicle.setType(vehicle.getType());
            vehicleService.insertVehicle(existingVehicle);
            return "Updated Successfully";
        }
        return "Vehicle Not Found";
    }

    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.getOneVehicle(id);

        if (vehicle.isPresent()) {
            vehicleService.deleteVehicle(id);
            return "Deleted Successfully";
        }
        return "Vehicle Not Found";
    }
}