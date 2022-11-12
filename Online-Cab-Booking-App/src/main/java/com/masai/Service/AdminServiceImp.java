package com.masai.Service;

import java.time.LocalDate;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Admin;
import com.masai.Entity.Customer;
import com.masai.Entity.TripBooking;
import com.masai.Exception.AdminExceptions;
import com.masai.Repository.AdminRepo;
import com.masai.Repository.CabDao;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.DriverDao;
import com.masai.Repository.TripDao;


@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private CustomerDao customerRepo;
	
	@Autowired 
	private DriverDao driverRepo;
	
	@Autowired
	private CabDao cabDao;
	
	@Autowired
	private TripDao tripRepo;

	@Override
	public Admin saveAdmin(Admin admin) throws AdminExceptions {
		System.out.println(admin);
		return adminRepo.save(admin);
	}

	@Override
	public Admin update(Admin admin) throws AdminExceptions {
		Optional<Admin> opt = adminRepo.findById(admin.getUserId());
		if (opt.isPresent()) {
			
			return adminRepo.save(admin);
		}
		throw new AdminExceptions("Invalid Id");
	}

	@Override
	public Admin delete(Integer id) throws AdminExceptions {
		Admin existingAdmin = adminRepo.findById(id).orElseThrow(() -> new AdminExceptions("Invalid Id"));
		adminRepo.delete(existingAdmin);

		return existingAdmin;
	}

	@Override //all trips detail of customer
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminExceptions {
		//customer exception
		Optional<Customer> opt = customerRepo.findById(customerid);
		if(opt.isPresent()) {
			List<TripBooking> trips = tripRepo.findAll();
			return trips;
		
		}
		throw new AdminExceptions("Invalid Id");
	}

	@Override

	public List<TripBooking> getTripsDriverwise() {
		
		List<TripBooking> list = tripRepo.findByDriverAscs();
		
		if(list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found");
		
	}


	@Override
	public List<TripBooking> getTripsCustomerwise() {
		List<TripBooking> list = tripRepo.findByCustomeridAsce();
		if(list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found");
		 
	}

	@Override
	public List<TripBooking> getTripsDatewise() throws AdminExceptions {
		List<TripBooking> list = tripRepo.findByFromdate_timeAsce();
		if(list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found");
	}

	@Override
	public List<TripBooking> getTripsDatewiseAndCustomer(Integer customerId, LocalDate date) throws AdminExceptions {
		List<TripBooking> list = tripRepo.findByCustomerIdAndFromdate_time(customerId, date);
		if(list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found for customer id "+customerId+" and date : "+date);
	}


}
