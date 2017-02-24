package edu.vehicle;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.util.DBQuries;
import edu.vehicle.dao.VehicleDao;
import edu.vehicle.model.Capacity;
import edu.vehicle.model.VehiclePark;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VehicleApplication.class)
@WebAppConfiguration
public class VehicleDaoTest {
	@Autowired 
	private VehicleDao  vehicleDao;
	@Autowired
	private SessionFactory sessionFactory;


	@Test
	public void testGetCapacityDetails() {
		Capacity capacity=  vehicleDao.getCapacityDetails();
		assertNotNull(capacity);
		assertNotNull(capacity.getId());
	}

	@Test
	public void testSaveVehicleDetailscheck() {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(DBQuries.CHECKGETVEHICLEDETAILS);
		List<VehiclePark> list= query.list();
		for (VehiclePark vehiclePark : list) {
			List<VehiclePark> list2 =vehicleDao.saveVehicleDetailscheck(vehiclePark.getVehicleId());
			assertNotNull(list2);
			assertNotNull(list2.size());

		}
	}  
	  
}
