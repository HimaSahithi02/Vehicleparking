package edu.vehicle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.vehicle.dao.VehicleDao;
import edu.vehicle.service.VehicleService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VehicleApplication.class)
@WebAppConfiguration
public class VehicleApplicationTests {
	@Autowired 
	private VehicleService  vehicleService;
	

	@Test
	public void contextLoads() {
		System.out.println(vehicleService.getCapacityDetails());
	}

}
