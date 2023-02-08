package com.employeeblockbuster.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class UserDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		 
	  @NotBlank(message = "name can't be empty !!")	  
	  @Size(min = 3 ,max = 100,message ="name must be between 3 to 100 charactors")
	  private String firstName;
	  
	  
	  @NotBlank(message = "name can't be empty !!")	  
	  @Size(min = 3 ,max = 100,message ="name must be between 3 to 100 charactors")
	  private String lastName;
	  
	
	  @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
	  message="use this format user@gmail.com") 
	  private String email;
	  
	  
	 
	  @NotBlank(message = "password can't be empty !!")	  
	  @Size(min = 8 ,max = 100,message="password must be between 8 to 100 charactors" ) 
	  private String password;
	  
	  //@AssertTrue(message="Must agree term and condition !!") 
	  private boolean agreed;
	  
	  private String role;   
	 

	public UserDtls() {	}

	public UserDtls(int id, String firstName, String lastName, String email, 
			                       String password,boolean agreed, String role) 
	{
		
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.agreed = agreed;
	this.role = role;
	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) 
	{
		this.role = role;
	}
	
	public boolean isAgreed() 
	{
		return agreed;
	}

	public void setAgreed(boolean agreed) 
	{
		this.agreed = agreed;
	}

	@Override
	public String toString() 
	{
		return "UserDtls [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName 
				               + ", email=" + email	+ ", password=" + password + ", agreed=" 
				               + agreed + ", role=" + role + "]";
	}	

}
