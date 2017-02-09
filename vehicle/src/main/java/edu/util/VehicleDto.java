package edu.util;
import java.sql.Timestamp;

public class VehicleDto {
private String vehicleId;
private String vehicleType;
private Timestamp inTime;
private Timestamp outTime;
private Integer cost;
public String getVehicleId() {
	return vehicleId;
}
public void setVehicleId(String vehicleId) {
	this.vehicleId = vehicleId;
}
public String getVehicleType() {
	return vehicleType;
}
public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}
public Timestamp getInTime() {
	return inTime;
}
public void setInTime(Timestamp inTime) {
	this.inTime = inTime;
}
public Timestamp getOutTime() {
	return outTime;
}
public void setOutTime(Timestamp outTime) {
	this.outTime = outTime;
}
public Integer getCost() {
	return cost;
}
public void setCost(Integer cost) {
	this.cost = cost;
}

}
