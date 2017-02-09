package edu.util;

public interface DBQuries {
	String GETCAPACITY = "from edu.model.Capacity";
	String GETVEHICLEDETAILS = "from edu.vehicle.model.VehiclePark v where v.vehicleId = :vehicleId and v.outTime is null";

}
