package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Customer;
import com.masai.Service.CustomerService;

import antlr.collections.List;


@RestController
@RequestMapping(value = "/customer")
public class customerController {
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customer/{Id}")
	public Customer getCustomer(@PathVariable("Id") Integer id)
	{    
		return service.findCustomer(id);
	}
	
	@PostMapping(value = "/save",consumes = "application/json")
	public Customer SaveStudent(@Valid @RequestBody Customer customer)
	{	System.out.println(customer);
		return service.saveCustomer(customer);
	}
	
}
