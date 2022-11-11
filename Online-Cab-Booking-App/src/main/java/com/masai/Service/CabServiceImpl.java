package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Cab;
import com.masai.Entity.Driver;
import com.masai.Exception.NotFoundException;
import com.masai.Exception.InvalidId;
import com.masai.Repository.CabDao;
import com.masai.Repository.DriverDao;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service("CabService")
public class CabServiceImpl implements CabService {

	@Autowired
	private CabDao cDao;
	

	@Autowired
	private DriverDao dDao;



	@Override
	public Cab insertCab(Cab cab) {
		Cab c=cDao.save(cab);
		return c;
	}
	

	@Override
	public Cab updateCab(Integer id,String type, Integer rate) throws NotFoundException {
		// TODO Auto-generated method stub
		java.util.Optional<Cab> opt = cDao.findById(id);
	
		  if(opt.isPresent())
		  {
			  Cab fCab=opt.get();
				fCab.setCarType(type);
				fCab.setRatePerKm(rate);
				Driver fDriver= fCab.getDriver();
				fDriver.setCab(fCab);;
				dDao.save(fDriver);
				return cDao.save(fCab);
			  
			  
			  
		  }else
		  {
			  throw new NotFoundException("Cab Not Found");
		  }
		 

			

	}

	

	@Override
	public List<String> viewCabsOfType() throws NotFoundException {
		// TODO Auto-generated method stub
		List<String> cabs = cDao.viewCarType();
		return cabs;
	}

	@Override
	public int countCabsOfType() throws NotFoundException {
		// TODO Auto-generated method stub
		List<Cab> listcab = cDao.findAll();
		return listcab.size();
	}



	
	



	
	
}
