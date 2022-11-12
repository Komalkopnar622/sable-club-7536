package com.masai.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Address;



public interface AddressDao extends JpaRepository<Address, Integer> {

}
