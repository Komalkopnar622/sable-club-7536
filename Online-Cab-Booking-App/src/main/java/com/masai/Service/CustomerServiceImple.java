package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Address;
import com.masai.Entity.Customer;
import com.masai.Exception.InvalidId;
import com.masai.Exception.Nullexception;
import com.masai.Repository.AddressDao;
import com.masai.Repository.CustomerDao;


@Service
public class CustomerServiceImple implements CustomerService {
 
	@Autowired
	private CustomerDao cdao;
    @Autowired
    private AddressDao Adao;

	
	@Override
    	public Customer saveCustomer(Customer customer) {
		return cdao.save(customer);
	}


	@Override
	public Customer findCustomer(Integer id) throws InvalidId {
	

		Customer ct=cdao.findById(id).orElseThrow(() -> new InvalidId("Customer with ID "+id+" does not exit.."));
		
		
		return ct;
		
	}
	@Override
	public Customer updateCustomer(Customer customer, Integer id) throws InvalidId {
		
		Customer c1=cdao.findById(id).orElseThrow(() -> new InvalidId("Customer with ID "+id+" does not exit.."));
		

		
		c1.setAddress(customer.getAddress());
		c1.setEmail(customer.getEmail());
		c1.setMobile(customer.getMobile());
		c1.setPassword(customer.getPassword());
		c1.setUsername(customer.getUsername());
		
		cdao.save(c1);
		
		return c1;
	}


	@Override
	public String deleteCustomer(Integer id) throws InvalidId {
		// TODO Auto-generated method stub
		Customer ct=cdao.findById(id).orElseThrow(() -> new InvalidId("Customer with ID "+id+" does not exit.."));
		Adao.delete(ct.getAddress());
		cdao.delete(ct);
		
		return "delete...";
	}
	
	@Override
	public List<Customer> getAllCustomerDetails() throws Nullexception {
		List<Customer> customers = cdao.findAll();
		if (customers.size() == 0)
			throw new Nullexception("No Employees are there");
		else
			return customers;
	}


	@Override
	public Customer vaildCustomer(String Email, String Password) throws InvalidId {
		// TODO Auto-generated method stub
		
		List<Customer> c1  =cdao.findAll();
		for(int i= 0; i < c1.size(); i++) {
			if(c1.get(i).getEmail().equals(Email) && c1.get(i).getPassword().equals(Password))
			     return c1.get(i);
			}
		 throw new InvalidId("Invalid Email and password");
	}
	

}
