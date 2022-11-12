package com.masai.Service;

import java.time.LocalDateTime;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.CurrentUserSession;
import com.masai.Entity.Customer;
import com.masai.Entity.CustomerDTO;
import com.masai.Exception.AdminExceptions;
import com.masai.Exception.InvalidPasswordException;
import com.masai.Exception.NotFoundException;
import com.masai.Exception.UserAlreadyExistWithuserId;
import com.masai.Repository.AdminRepo;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.DriverDao;
import com.masai.Repository.SessionRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLogInImpl implements UserLogIn {
	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private DriverDao driverRepo;

	@Autowired
	private CustomerDao customerRepo;

	@Autowired
	private SessionRepo sessionRepo;

	@Override
	public String logIntoAccount(CustomerDTO userDto) {
		Optional<Customer> opt_customer = customerRepo.findById(userDto.getUserId());

		Integer userId = opt_customer.get().getCustomerId();
//				.getUserId();

		Optional<CurrentUserSession> currentUserOptional = sessionRepo.findById(userId);

		if (!opt_customer.isPresent()) {
			throw new AdminExceptions("user not found");
		}
		if (currentUserOptional.isPresent()) {
			throw new UserAlreadyExistWithuserId("User already logged in with this number");
		}
		if (opt_customer.get().getPassword().equals(userDto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(opt_customer.get().getCustomerId(), key,
					LocalDateTime.now());
			sessionRepo.save(currentUserSession);

			return currentUserSession.toString();
		} else {
			throw new InvalidPasswordException("Please Enter Valid Password");
		}

	}

	@Override
	public String logOutFromAccount(String key) {
		Optional<CurrentUserSession> currentUserOptional = sessionRepo.findByUuid(key);

		if (!currentUserOptional.isPresent()) {
			throw new NotFoundException("User is not logged in with this number");
		}

		CurrentUserSession currentUserSession = currentUserOptional.get();
		sessionRepo.delete(currentUserSession);

		return "Logged Out...";
	}

}
