package com.masai.Repository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.masai.Entity.Customer;
import com.masai.Service.CustomerService;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	
}
