package com.masai.Service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service("CabService")
public class CabServiceImpl implements CabService {

	@Override
	public Cab updateCab(Integer id, String type, Integer rate) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> viewCabsOfType() throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCabsOfType() throws NotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}
