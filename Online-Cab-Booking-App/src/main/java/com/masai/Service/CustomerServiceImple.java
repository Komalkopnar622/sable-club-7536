package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Exception.CustomerException;
import com.masai.Exception.Nullexception;
import com.masai.Repository.CustomerDao;

@Service
public class CustomerServiceImple implements CustomerService{

	@Autowired
	private CustomerDao cRepo;
	
	@Override
	public Customer createCustomer(Customer customer) {
		Customer savedCustomer=cRepo.save(customer);
		return savedCustomer;
	}

//	@Override
//	public Customer updateCustomer(Customer customer) throws CustomerException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String deleteCustomer(Integer customerId) throws CustomerException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Customer ViewCustomer(Integer customerId) throws CustomerException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Customer> ViewCustomers() throws Nullexception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Customer vaildCustomer(String Email, String Password) throws CustomerException {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
