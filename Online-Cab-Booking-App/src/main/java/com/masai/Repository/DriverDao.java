package com.masai.Repository;

import com.masai.Entity.Driver;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDao extends JpaRepository<Driver,Integer>{
	@Query("from Driver d where d.rating>=4.5 AND d.available='true'")
	public List<Driver> viewBestDriver();
	
	@Query("from Driver d where d.available=true")
	public List<Driver> findByAvailable();

}
