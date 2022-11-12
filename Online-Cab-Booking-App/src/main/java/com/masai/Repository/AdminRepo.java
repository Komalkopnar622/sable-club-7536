package com.masai.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.*;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
