package com.cg.ritam.HomeInsurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ritam.HomeInsurance.entities.User;
import com.cg.ritam.HomeInsurance.exceptions.UserNotFoundException;
import com.cg.ritam.HomeInsurance.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepository iUserRepository;

	@Override
	public User addNewUser(User user) {
		return this.iUserRepository.save(user);
	}

	@Override

	 public User signIn(String username, String password) throws UserNotFoundException{

	 User u = this.iUserRepository.findUserByUserIdAndPassword(Integer.parseInt(username),password);

	 if(u==null) throw new UserNotFoundException("User not found");

	 return u;

	 }

}
