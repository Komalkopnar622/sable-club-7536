package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.Entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	
}
