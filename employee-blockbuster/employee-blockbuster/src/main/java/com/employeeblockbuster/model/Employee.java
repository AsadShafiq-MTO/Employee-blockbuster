package com.employeeblockbuster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import lombok.Data;
@Entity
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;	
	
	@NotBlank(message = "Name can't be empty !!")
	@Size(min = 3 ,max = 100,message =" Name must be between 3 to 50 character" )
	private String name;
	
	//@NotBlank(message = "image can't be empty !!")	
    @Column(nullable = true, length = 64)
	private String image;
	
	@NotBlank(message = "jobTitle can't be empty !!")	
	private String jobTitle;
	
	@NotBlank(message = "Qualification can't be empty !!")	
	private String qualification;
	
	@NotBlank(message = "Birth Date can't be empty !!")	
	private String dateOfBirth;	
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message="use this format user@gmail.com")
	private String email;
	
	@NotBlank(message = "Gender can't be empty !!")	
	private String gender;
	
	@NotBlank(message = "Address can't be empty !!")
	@Size(max = 150,message =" Address must be 150 charactor" )
	private String address;	

	@NotBlank(message = "Phone Number can't be empty !!")
	@Size(min = 12 ,max = 12,message ="Employee phone number must be 12 charactors" )
	private String phone;
	
	@Range(min=1, max=1000000)
	@NotNull(message= "positive number value is required")
	@Min(value=1, message="positive number, min 1 is required")
	private int salary;
	
	@NotBlank(message = "Employee Type can't be empty !!")	
	private String employeeType;
	
	@NotBlank(message = "Start Date Type can't be empty !!")	
	private String startDate;

	public Employee() 
	{ 
		System.out.println("default Constractor");
	}

	public Employee(Integer id,String name,String image,String jobTitle,String qualification,
			         String dateOfBirth,String email,String gender,String address,String phone,
			         int salary,String employeeType, String startDate) 
	{
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.jobTitle = jobTitle;
		this.qualification = qualification;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.salary = salary;
		this.employeeType = employeeType;
		this.startDate = startDate;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getImage() 
	{
		return image;
	}

	public void setImage(String image) 
	{
		this.image = image;
	}
	
	@Transient
    public String getImagePath() 
	{
        
		if (image == null || id == null ) return null;     //// 
         
        return "/user-photos/" + id + "/" + image;
    }

	public String getJobTitle() 
	{
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) 
	{
		this.jobTitle = jobTitle;
	}

	public String getQualification() 
	{
		return qualification;
	}

	public void setQualification(String qualification) 
	{
		this.qualification = qualification;
	}

	public String getDateOfBirth() 
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) 
	{
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getPhone() 
	{
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public int getSalary() 
	{
		return salary;
	}

	public void setSalary(int salary) 
	{
		this.salary = salary;
	}

	public String getEmployeeType() 
	{
		return employeeType;
	}

	public void setEmployeeType(String employeeType) 
	{
		this.employeeType = employeeType;
	}

	public String getStartDate() 
	{
		return startDate;
	}

	public void setStartDate(String startDate) 
	{
		this.startDate = startDate;
	}
		
	@Override
	public String toString() 
	{
		return "Employee [id=" + id + ", name=" + name+ ", image=" + image  + ", jobTitle=" + jobTitle
				+ ", qualification=" + qualification + ", dateOfBirth=" + dateOfBirth + ", email=" + email + 
				", gender="+ gender + ", address=" + address + ", phone=" + phone + ", salary=" + salary + 
				", employeeType="+ employeeType + ", startDate=" + startDate + "]";
	}
	
}

	