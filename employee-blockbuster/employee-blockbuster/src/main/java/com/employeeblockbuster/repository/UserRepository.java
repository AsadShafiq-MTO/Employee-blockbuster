package com.employeeblockbuster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeeblockbuster.model.UserDtls;

@Repository
public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	 @Query("select u from UserDtls u where u.email =:email")	  
	 public UserDtls getUserByUserName(@Param("email")String email);
	 
	 public boolean existsByEmail(String email);
		  
	 public UserDtls findByEmail(String email);	 

}