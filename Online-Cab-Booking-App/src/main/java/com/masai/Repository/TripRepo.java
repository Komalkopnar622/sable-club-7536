package com.masai.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Entity.TripBooking;

public interface TripRepo extends JpaRepository<TripBooking, Integer> {
	
	@Query("from TripBooking t where t.customerId=?1")
	public List<TripBooking> findByCustomerId(Integer customerId);
	
	@Query("select sum(t.bill) from TripBooking t where t.customerId=?1")
	public float totalBillBycustomerId(Integer customerId);
	
	@Query("from TripBooking  order by fromdate_time")
	public List<TripBooking> findByFromdate_timeAsce();
	
	@Query("from TripBooking order by CustomerId")
	public List<TripBooking> findByCustomeridAsce();
	
	@Query("from TripBooking where CustomerId=:customerId AND Fromdate_time=:date")
	public List<TripBooking> findByCustomerIdAndFromdate_time(Integer customerId, LocalDate date);
	
	@Query("from TripBooking Group by driver_id ORDER by driver_id")
	public List<TripBooking> findByDriverAscs();
	

}
