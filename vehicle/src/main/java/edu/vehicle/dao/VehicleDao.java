package edu.vehicle.dao;

import java.util.List;

import edu.vehicle.model.Capacity;
import edu.vehicle.model.Token;
import edu.vehicle.model.VehiclePark;

public interface VehicleDao {
	public Capacity getCapacityDetails();
	public List<VehiclePark> getVehicleDetails(String vehicleId);
	public void saveVehicleDetails(VehiclePark vehiclePark);
	public void updateVehicleDetails(VehiclePark vehiclePark);
}
