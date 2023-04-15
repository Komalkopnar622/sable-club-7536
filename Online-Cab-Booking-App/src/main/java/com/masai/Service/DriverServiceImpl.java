package com.masai.Service;

import java.util.List;

import com.masai.entity.Driver;
import com.masai.exception.DriverNotFoundException;
import com.masai.exception.InvalidId;

public class DriverServiceImpl implements DriverService {

	@Override
	public Driver insertDriver(Driver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver viewDriverById(Integer id) throws InvalidId {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver updateDriver(Integer id, Integer license, Boolean available) throws DriverNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDriverById(Integer id) throws DriverNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> viewBestDriver() throws DriverNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
