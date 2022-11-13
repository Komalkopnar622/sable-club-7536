package com.masai.Service;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Address;
import com.masai.Entity.Cab;
import com.masai.Entity.Customer;
import com.masai.Entity.Driver;
import com.masai.Exception.InvalidId;
import com.masai.Exception.NotFoundException;
import com.masai.Repository.CabDao;
import com.masai.Repository.DriverDao;



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
//				Driver fDriver= fCab.getDriver();
//				fDriver.setCab(fCab);;
//				dDao.save(fDriver);
				return cDao.save(fCab);
			  
			  
			  /*
			  //Driver driver = dDao.getDriverByCabId(cab.getCabId());
		
			  Cab cab1 = opt.get();
			  Driver cabDriver=cab1.getDriver();
			  cabDriver.setCab(cab1);
			  dDao.save(cabDriver);
			 return cDao.save(cab1);*/
			  
			  
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


	@Override
	public Cab deleteCab(Integer id) throws NotFoundException {
		java.util.Optional<Cab> cab = cDao.findById(id);
				cDao.findById(id);
				
		
		if(cab.isPresent()) {
			Cab cab1 = cab.get();
		    cDao.delete(cab1);
		    return cab1;
		}else {
			throw new NotFoundException("Cab Not found");
		}
	}


}
