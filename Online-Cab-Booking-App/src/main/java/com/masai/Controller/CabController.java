package com.masai.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

//import com.masai.Entity.Admin;
import com.masai.Entity.Cab;
import com.masai.Entity.Customer;
import com.masai.Service.CabService;

@RestController
public class CabController {
	
	@Autowired
	private CabService cService;
	
	@PostMapping("/cabs")
	public ResponseEntity<Cab> insertCab(@Valid @RequestBody Cab cab){
		Cab addedCab=cService.insertCab(cab);
		return new ResponseEntity<Cab>(addedCab,HttpStatus.ACCEPTED);
				
		
	}
	@GetMapping("/cabsCount")
    public String countCabsOfType() throws NotFoundException{
   	int countCab = cService.countCabsOfType();
   	
   	return "Number of Cabs Abvailable " + countCab;
    }
	
	@DeleteMapping("/cabs/{id}")
	public ResponseEntity<Cab> deleteCabByIdHandler(@PathVariable("id") Integer id) throws NotFoundException{
		
		Cab deletedCab= cService.deleteCab(id);
				
		
		return new ResponseEntity<Cab>(deletedCab,HttpStatus.OK);
		
	}
	@PutMapping("/cabs")
    public ResponseEntity<Cab> updateCabHandler(@RequestParam Integer id,
									@RequestParam String type,
									@RequestParam Integer rate) throws NotFoundException
    {
		
		Cab updatedCab = cService.updateCab(id,type,rate);
		return new ResponseEntity<Cab>(updatedCab,HttpStatus.ACCEPTED);
		
    	
		
    }
	
	
	
	
	
	@GetMapping("/cabs")
	public ResponseEntity<List<String>> viewCabsHandler(@RequestParam String carType) throws NotFoundException
	{
		
		List<String> cabs = cService.viewCabsOfType();
		
        return new ResponseEntity<List<String>>(cabs,HttpStatus.OK);
		
	}
	
	
	
}
