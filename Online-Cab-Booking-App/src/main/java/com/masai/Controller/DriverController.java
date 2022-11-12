package com.masai.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Driver;
import com.masai.Exception.DriverNotFoundException;
import com.masai.Exception.InvalidId;
import com.masai.Service.DriverService;

@RestController
public class DriverController {
	
	@Autowired
	private DriverService dService;

	@PostMapping("/drivers")
	public ResponseEntity<Driver> insertDriver(@Valid @RequestBody Driver driver){
		Driver addedDriver= dService.insertDriver(driver);
		return new ResponseEntity<Driver>(addedDriver,HttpStatus.ACCEPTED);
	}
	
	
	
	
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> viewDriverById(@PathVariable("id") Integer id) throws InvalidId, DriverNotFoundException{
		Driver foundDriver= dService.viewDriverById(id);
		return new ResponseEntity<Driver>(foundDriver,HttpStatus.ACCEPTED);
	}
	
	
	
	@PutMapping("/drivers")
	public ResponseEntity<Driver> updateDriver(@RequestParam Integer id,
								@RequestParam Integer lic,
								@RequestParam Boolean avail) throws DriverNotFoundException {
		Driver driver=dService.updateDriver(id,lic,avail);
		return new ResponseEntity<Driver>(driver,HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/drivers/{id}")
	public String deleteDriverById(@PathVariable("id") Integer id) throws DriverNotFoundException {
		return dService.deleteDriverById(id);
	}
	
	
	
	@GetMapping("/topDrivers")
	public ResponseEntity<List<Driver>> viewBestDrivers() throws DriverNotFoundException{
		List<Driver> list=dService.viewBestDriver();
		return new ResponseEntity<List<Driver>>(list,HttpStatus.ACCEPTED);
	}

}
