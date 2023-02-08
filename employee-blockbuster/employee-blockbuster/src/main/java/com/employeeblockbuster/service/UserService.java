
  package com.employeeblockbuster.service;
  
  import java.util.List;

import com.employeeblockbuster.model.UserDtls;
  
  public interface UserService {
  
  public UserDtls createUser(UserDtls user);
  
  public boolean checkEmail(String email);
  
  public List<UserDtls> findAll();  
 	
  public UserDtls getUserDtls(int id); 

  public UserDtls findByEmails(String email);
  
  }
 