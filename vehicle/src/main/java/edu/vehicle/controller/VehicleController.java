package edu.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.util.VehicleDto;
import edu.vehicle.model.Capacity;
import edu.vehicle.model.Token;
import edu.vehicle.model.VehiclePark;
import edu.vehicle.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "/getCapacitydetail", method = RequestMethod.GET)
	public Capacity getCapacitydetails2() {
		return vehicleService.getCapacityDetails();

	}

	@RequestMapping(value = "/getVehicleDeatils/{vehicleId}", method = RequestMethod.GET)
	public VehicleDto saveVehicleDetails(@PathVariable String vehicleId) {
		return vehicleService.getVehicleDetails(vehicleId);

	}

	@RequestMapping(value = "/saveVehicledetails", method = RequestMethod.POST)
	public Token saveVehicleDetails2(@RequestBody VehiclePark vehiclePark) {
		System.out.println(vehiclePark.getVehicleId());
		System.out.println(vehiclePark.getVehicleType());
		System.out.println(vehiclePark.getInTime());
		return vehicleService.saveVehicleDetails(vehiclePark);

	}

}
