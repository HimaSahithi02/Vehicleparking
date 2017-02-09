package edu.vehicle.service;

import java.sql.Timestamp;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.util.CommonUtil;
import edu.util.VehicleDto;
import edu.vehicle.dao.VehicleDao;
import edu.vehicle.model.Capacity;
import edu.vehicle.model.Token;
import edu.vehicle.model.VehiclePark;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleDao vehicleDao;

	public Capacity getCapacityDetails() {
		return vehicleDao.getCapacityDetails();
	}

	@Override
	public VehicleDto getVehicleDetails(String vehicleId) {
		List<VehiclePark> vehicleParks = vehicleDao.getVehicleDetails(vehicleId);
		VehicleDto vehicleDto = null;
		for (VehiclePark vehiclePark : vehicleParks) {
			vehicleDto = new VehicleDto();
			vehicleDto.setVehicleId(vehiclePark.getVehicleId());
			vehicleDto.setVehicleType(vehiclePark.getVehicleType());
			vehicleDto.setInTime(vehiclePark.getInTime());
			Timestamp outTime = new Timestamp(System.currentTimeMillis());
			DateTime inTime1 = new DateTime(vehiclePark.getInTime().getTime());
			DateTime outTime2 = new DateTime(outTime.getTime());
			Integer hours = (Days.daysBetween(inTime1.withTimeAtStartOfDay(), outTime2.withTimeAtStartOfDay())
					.getDays()) * 24;
			Integer hourostheday = outTime2.getHourOfDay() - inTime1.getHourOfDay();
			hours += hourostheday;
			System.out.println("days:" + hours);
			Capacity capacity = vehicleDao.getCapacityDetails();
			Integer cost = null;
			if (hours == 0 && "two".equalsIgnoreCase(vehiclePark.getVehicleType())) {
				cost = capacity.getTwoCost();
			} else if (hours != 0 && "two".equalsIgnoreCase(vehiclePark.getVehicleType())) {
				cost = capacity.getTwoCost() + (hours * 2);
			}
			if (hours == 0 && "four".equalsIgnoreCase(vehiclePark.getVehicleType())) {
				cost = capacity.getFourCost();
			} else if (hours != 0 && "four".equalsIgnoreCase(vehiclePark.getVehicleType())) {
				cost = capacity.getFourCost() + (hours * 4);
			}
			vehicleDto.setCost(cost);
			vehicleDto.setOutTime(outTime);
			vehiclePark.setOutTime(outTime);
			updateVehicleDetails(vehiclePark);
		}

		return vehicleDto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Token saveVehicleDetails(VehiclePark vehiclePark) {
		Token token = new Token();
		System.out.println(vehiclePark.getId());
		token.setTokenid(CommonUtil.getTokenId());
		token.setInTime(vehiclePark.getInTime());
		token.setVehicleType(vehiclePark.getVehicleType());
		token.setVehicle_Id(vehiclePark.getVehicleId());
		vehiclePark.setToken(token);
		vehicleDao.saveVehicleDetails(vehiclePark);
		return token;
	}

	@Override
	public void updateVehicleDetails(VehiclePark vehiclePark) {
		vehicleDao.updateVehicleDetails(vehiclePark);
	}
}
