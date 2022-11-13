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
import com.masai.Repository.SessionDao;
import net.bytebuddy.utility.RandomString;

@Service
public class UserLogInImpl implements UserLogIn {
	@Autowired
	private AdminRepo adminDao;

	@Autowired
	private DriverDao driverDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private SessionDao sessionDao;

	@Override
	public String logIntoAccount(CustomerDTO userDto) {
		Optional<Customer> opt_customer = customerDao.findById(userDto.getUserId());

		Integer userId = opt_customer.get().getUserId();

		Optional<CurrentUserSession> currentUserOptional = sessionDao.findById(userId);

		if (!opt_customer.isPresent()) {
			throw new AdminExceptions("user not found");
		}
		if (currentUserOptional.isPresent()) {
			throw new UserAlreadyExistWithuserId("User already logged in with this number");
		}
		if (opt_customer.get().getPassword().equals(userDto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(opt_customer.get().getUserId(), key,
					LocalDateTime.now());
			sessionDao.save(currentUserSession);

			return currentUserSession.toString();
		} else {
			throw new InvalidPasswordException("Please Enter Valid Password");
		}

	}

	@Override
	public String logOutFromAccount(String key) {
		Optional<CurrentUserSession> currentUserOptional = sessionDao.findByUuid(key);

		if (!currentUserOptional.isPresent()) {
			throw new NotFoundException("User is not logged in with this number");
		}

		CurrentUserSession currentUserSession = currentUserOptional.get();
		sessionDao.delete(currentUserSession);

		return "Logged Out...";
	}

}
