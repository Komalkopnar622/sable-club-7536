package com.masai.Service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.masai.Entity.Customer;
import com.masai.Exception.CustomerException;
import com.masai.Exception.Nullexception;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	public Customer findCustomer(Integer id)throws CustomerException;
	
//	public Customer updateCustomer(Customer customer)throws CustomerException;

	
//	public String deleteCustomer(Integer id)throws CustomerException;
//	public List<Customer> allCustomer()throws Nullexception;
//	public Customer vaildCustomer(String Email,String Password)throws CustomerException;
}
