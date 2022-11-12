package com.masai.Service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.masai.Entity.Cab;

public interface CabService {
	
	
	public Cab updateCab(Integer id,String type, Integer rate) throws NotFoundException;
	
	public List<String> viewCabsOfType() throws NotFoundException;
	
	public int countCabsOfType() throws NotFoundException;

}
