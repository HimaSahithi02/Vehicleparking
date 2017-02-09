package edu.vehicle.service;

import edu.util.VehicleDto;
import edu.vehicle.model.Capacity;
import edu.vehicle.model.Token;
import edu.vehicle.model.VehiclePark;

public interface VehicleService {
	public Capacity getCapacityDetails();
	public VehicleDto getVehicleDetails(String vehicleId);
	public Token saveVehicleDetails(VehiclePark vehiclePark);
	public void updateVehicleDetails(VehiclePark vehiclePark);

}
