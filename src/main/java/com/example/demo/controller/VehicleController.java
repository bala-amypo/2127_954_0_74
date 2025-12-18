package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicles") // base path
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // CREATE
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.insertVehicle(vehicle);
    }

    // READ ALL
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleService.getOneVehicle(id);
    }

    // UPDATE
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
            return "Vehicle Updated Successfully ✅";
        }
        return "Vehicle Not Found ❌";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {

        Optional<Vehicle> vehicle = vehicleService.getOneVehicle(id);

        if (vehicle.isPresent()) {
            vehicleService.deleteVehicle(id);
            return "Vehicle Deleted Successfully ✅";
        }
        return "Vehicle Not Found ❌";
    }
}