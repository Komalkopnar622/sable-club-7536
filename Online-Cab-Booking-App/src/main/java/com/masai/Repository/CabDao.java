package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Entity.Cab;

@Repository
public interface CabDao extends JpaRepository<Cab, Integer>{
	
	@Query("select distinct carType from Cab")
	public List<String> viewCarType();

}
