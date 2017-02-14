package edu.vehicle.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLEPARK")
public class VehiclePark {
	@Id
	@GeneratedValue
	private Integer id;
	private String vehicleId;
	private String vehicleType;
	private Timestamp inTime;
	private Timestamp outTime;

	private Token token;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "vehicleid")
	public String getVehicleId() {
		return vehicleId;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tokenid")
	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(name = "type")
	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Column(name = "intime")
	public Timestamp getInTime() {
		return inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	@Column(name = "outtime")
	public Timestamp getOutTime() {
		return outTime;
	}

	public void setOutTime(Timestamp outTime) {
		this.outTime = outTime;
	}

}
