package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Customer;
import com.masai.Service.CustomerService;


@RestController
@RequestMapping(value = "/customer")
public class customerController {
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomerDetails(@Valid @RequestBody Customer customer) {
		Customer savedCustomer=cService.createCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}
}
