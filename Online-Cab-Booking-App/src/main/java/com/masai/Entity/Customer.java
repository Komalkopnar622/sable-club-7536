package com.masai.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends User{
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + "]";
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	
}
