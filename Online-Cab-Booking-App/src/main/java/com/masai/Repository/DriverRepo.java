package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.masai.Entity.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer>{
	
	@Query("from Driver d where d.available=true")
	public List<Driver> findByAvailable();
	

}
