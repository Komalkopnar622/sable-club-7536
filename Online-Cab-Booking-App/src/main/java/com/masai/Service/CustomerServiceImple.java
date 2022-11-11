package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Exception.CustomerException;
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
	public Customer findCustomer(Integer id) throws CustomerException {

		Customer ct = cdao.findById(id).orElseThrow(() -> new CustomerException("Customer with ID " + id + " does not exit.."));

		return ct;

	}

}
