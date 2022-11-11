package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.TripBooking;

public interface TripRepo extends JpaRepository<TripBooking, Integer> {
	

}
