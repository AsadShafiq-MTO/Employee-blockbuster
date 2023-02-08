
  package com.employeeblockbuster.service;
  
  import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.stereotype.Service; 
import com.employeeblockbuster.model.UserDtls; 
import com.employeeblockbuster.repository.UserRepository;
  
  @Service public class UserServiceImpl implements UserService 
  {
	  
	  @Autowired 
	  private UserRepository userRepo;
	  
	  @Autowired 
	  private BCryptPasswordEncoder passwordEncode;
	  
	  @Override 
	  public UserDtls createUser(UserDtls user) 
	  {	  
	  user.setPassword(passwordEncode.encode(user.getPassword()));
	  user.setRole("ROLE_USER"); 
	  user.setAgreed(true);	  
	  return userRepo.save(user); 
	  
	  }
	  
	  @Override 
	  public boolean checkEmail(String email) 
	  {
	  
	  return userRepo.existsByEmail(email); 
	  
	  }	  
	  
	  @Override
	  public List<UserDtls> findAll() 
	  {				  
		return userRepo.findAll();	
		
	  }
	  
	 @SuppressWarnings("deprecation")
	 @Override
	  public UserDtls getUserDtls(int id) 
	  {		
		return userRepo.getById(id);
		
	  }

	@Override
	public UserDtls findByEmails(String email)
	{
       		

		return userRepo.findByEmail(email);
	} 
	  
   }
	 