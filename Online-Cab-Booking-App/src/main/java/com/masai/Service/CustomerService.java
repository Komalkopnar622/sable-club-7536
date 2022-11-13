package com.masai.Service;


import java.util.List;

import com.masai.Entity.Customer;
import com.masai.Exception.InvalidId;
import com.masai.Exception.Nullexception;


public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	public Customer findCustomer(Integer id)throws InvalidId;
	public Customer updateCustomer(Customer customer,Integer id)throws InvalidId;
	public String deleteCustomer(Integer id)throws InvalidId;
	public List<Customer> getAllCustomerDetails()throws Nullexception;
	public Customer vaildCustomer(String Email,String Password)throws InvalidId;
	
}
