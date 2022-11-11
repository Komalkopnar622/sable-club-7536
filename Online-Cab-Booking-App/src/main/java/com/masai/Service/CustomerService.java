package com.masai.Service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.masai.Entity.Customer;
import com.masai.Exception.CustomerException;
import com.masai.Exception.Nullexception;

public interface CustomerService {

    public Customer createCustomer(Customer customer) ;
//    public Customer updateCustomer(Customer customer) throws CustomerException;
//    public String deleteCustomer(Integer customerId) throws CustomerException;
//    public Customer ViewCustomer(Integer customerId) throws CustomerException;
//    public List<Customer> ViewCustomers() throws Nullexception;
//    public Customer vaildCustomer(String Email,String Password) throws CustomerException;
}
