package edu.vehicle;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.util.VehicleDto;
import edu.vehicle.dao.VehicleDao;
import edu.vehicle.model.Capacity;
import edu.vehicle.model.VehiclePark;
import edu.vehicle.service.VehicleService;
import edu.vehicle.service.VehicleServiceImpl;

public class VehicleServiceTest {
	 @InjectMocks
	 private VehicleService vehicleService;
	 @Mock
	 private VehicleDao dao;
	 @Before
	    public void initMocks(){
		 vehicleService= new VehicleServiceImpl();
	        MockitoAnnotations.initMocks(this);
	       
	    }
	 @Test
		public void testGetCapacityDetails() {
		 Capacity capacity = new Capacity();
		 capacity.setId(4);
		 Mockito.when(dao.getCapacityDetails()).thenReturn(capacity);
			Capacity capacity2=  vehicleService.getCapacityDetails();
			System.out.println(capacity2.getId());
			Assert.assertNotNull(capacity2);
		}
	 @Test
		public void testSaveVehicleDetailscheck() {
		 List<VehiclePark> list2 = new ArrayList<>();
		 VehiclePark vehiclePark = new VehiclePark();
		 vehiclePark.setId(1);
		 vehiclePark.setVehicleId("234");
		 vehiclePark.setVehicleType("two");
		 list2.add(vehiclePark);
		 Mockito.when(dao.getVehicleDetails(Mockito.anyObject())).thenReturn(list2);
				VehicleDto dto =vehicleService.saveVehicleDetailscheck("ka234");
				Assert.assertEquals("two", dto.getVehicleType());

			}
	 @Test
		public void testGetVehicleDetails() {
		 List<VehiclePark> list2 = new ArrayList<>();
		 VehiclePark vehiclePark = new VehiclePark();
		 vehiclePark.setId(1);
		 vehiclePark.setVehicleId("234");
		 vehiclePark.setVehicleType("two");
		 vehiclePark.setInTime(new Timestamp(System.currentTimeMillis()));
		 list2.add(vehiclePark);
		 Mockito.when(dao.getVehicleDetails(Mockito.anyObject())).thenReturn(list2);
		 Capacity capacity= new Capacity();
		 capacity.setTwoCost(45);
		 Mockito.when(dao.getCapacityDetails()).thenReturn(capacity);
				VehicleDto dto =vehicleService.getVehicleDetails("ka234");
				Assert.assertEquals((double)45, (double)dto.getCost(),1);

			}

}