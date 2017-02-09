package edu.vehicle.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.util.DBQuries;
import edu.vehicle.model.Capacity;
import edu.vehicle.model.Token;
import edu.vehicle.model.VehiclePark;

@Repository
public class VehicleDaoimpl implements VehicleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Capacity getCapacityDetails() {
		Session session = sessionFactory.openSession();
		return session.get(Capacity.class, Integer.valueOf(1));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehiclePark> getVehicleDetails(String vehicleId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(DBQuries.GETVEHICLEDETAILS);
		query.setParameter("vehicleId", vehicleId);
		return query.list();
	}

	@Override
	@Transactional
	public void saveVehicleDetails(VehiclePark vehiclePark) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Capacity capacity = session.get(Capacity.class, Integer.valueOf(1));
		if (vehiclePark.getVehicleType().equalsIgnoreCase("two")) {
			capacity.setTwo(capacity.getTwo() - 1);
		} else {
			capacity.setFour(capacity.getFour() - 1);
		}
		session.update(capacity);
		session.save(vehiclePark);
		transaction.commit();

	}

	@Override
	public void updateVehicleDetails(VehiclePark vehiclePark) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(vehiclePark);
		Capacity capacity = session.get(Capacity.class, Integer.valueOf(1));

		if (vehiclePark.getVehicleType().equalsIgnoreCase("two")) {
			capacity.setTwo(capacity.getTwo() + 1);
		} else {
			capacity.setFour(capacity.getFour() + 1);
		}
		session.update(capacity);
		transaction.commit();
	}

}
