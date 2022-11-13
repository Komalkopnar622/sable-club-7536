package com.masai.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Customer;
import com.masai.Exception.Nullexception;
import com.masai.Service.CustomerService;



@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping(value = "/save",consumes = "application/json")
	public Customer SaveCustomerDetails(@Valid @RequestBody Customer customer)
	{	System.out.println(customer);
		return service.saveCustomer(customer);
	}
	@PutMapping("/update/{id}")
	public Customer updateCustomerDetails(@Valid @RequestBody Customer customer,@PathVariable("id")Integer id )
	{
		
		return service.updateCustomer(customer,id);
	}
    @DeleteMapping("/customer/delete/{id}")
	public String deleteCustomerDetails(@PathVariable("id")Integer id) {
		
    	return service.deleteCustomer(id);
	}
    
	@GetMapping("/customer/{Id}")
	public Customer getCustomerDetails(@PathVariable("Id") Integer id)
	{    
		return service.findCustomer(id);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerDetails() throws Nullexception{
		List<Customer> customers=service.getAllCustomerDetails();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
	@GetMapping("/customer/{Email}/{Password}")
	public Customer validCustomerDetailsUsingEmailAndPassword(@PathVariable("Email") String Email,@PathVariable("Password")String Password)
	{    
		return service.vaildCustomer(Email, Password);
	}
	
	
}

