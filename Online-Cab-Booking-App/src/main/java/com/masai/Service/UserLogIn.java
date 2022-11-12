package com.masai.Service;

import com.masai.Entity.CustomerDTO;


public interface UserLogIn {
	
	public String logIntoAccount(CustomerDTO userDto);
	
	public String logOutFromAccount(String key);
}