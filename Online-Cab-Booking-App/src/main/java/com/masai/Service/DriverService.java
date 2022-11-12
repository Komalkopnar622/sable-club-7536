package com.masai.Service;

import java.util.List;

import com.masai.Entity.Driver;
import com.masai.Exception.DriverNotFoundException;
import com.masai.Exception.InvalidId;

public interface DriverService {
	
	public Driver insertDriver(Driver driver);
	public Driver viewDriverById(Integer id) throws InvalidId, DriverNotFoundException;
	public Driver updateDriver(Integer id,Integer license, Boolean available)throws DriverNotFoundException;
	public String deleteDriverById(Integer id)throws DriverNotFoundException;
	public List<Driver> viewBestDriver()throws DriverNotFoundException;


}
