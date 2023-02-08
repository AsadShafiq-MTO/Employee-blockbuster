package com.employeeblockbuster.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.employeeblockbuster.model.UserDtls;
import com.employeeblockbuster.repository.UserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("In method loadUserByUsername, having email "+username);
		UserDtls user = userRepo.getUserByUserName(username);
		/* UserDtls user = userRepo.findByEmail(email); */

		if (user != null)
		{
			/*
			 * CustomUserDetails customUserDetails =new CustomUserDetails(user); 
			 * return customUserDetails;
			 */
			
			/* OR */
			
			return new CustomUserDetails(user);
		}

		throw new UsernameNotFoundException("user not available");
	}

}
