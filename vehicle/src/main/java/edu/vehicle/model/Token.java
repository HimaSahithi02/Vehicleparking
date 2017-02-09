package edu.vehicle.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Token {
	
@Column(name="vehicle_id")
public String getVehicle_Id() {
		return vehicle_Id;
	}
	public void setVehicle_Id(String vehicle_Id) {
		this.vehicle_Id = vehicle_Id;
	}
private String tokenid;
private String vehicle_Id;
private String  vehicleType;
private Timestamp inTime;
private Timestamp outTime;

@Id
@Column(name="tokenid")
public String getTokenid() {
	return tokenid;
}
public void setTokenid(String tokenid) {
	this.tokenid = tokenid;
}

@Column(name="vehicletype")
public String getVehicleType() {
	return vehicleType;
}
public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}
@Column(name="intime")
public Timestamp getInTime() {
	return inTime;
}
public void setInTime(Timestamp inTime) {
	this.inTime = inTime;
}
@Column(name="outtime")
public Timestamp getOutTime() {
	return outTime;
}
public void setOutTime(Timestamp outTime) {
	this.outTime = outTime;
}


}
