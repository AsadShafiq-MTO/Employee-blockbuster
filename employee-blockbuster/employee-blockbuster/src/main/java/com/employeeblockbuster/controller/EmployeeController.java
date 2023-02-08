package com.employeeblockbuster.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.employeeblockbuster.model.Employee;
import com.employeeblockbuster.repository.EmployeeRepo;

@Controller
//@RequestMapping("/user")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;
	 
	@Autowired
	
	public EmployeeController(EmployeeRepo employeeRepo) 
	{
		
	    this.employeeRepo = employeeRepo;	     
	}
	
	@GetMapping("/indexEmployee")
	public String indexEmployee(Model model)
	{
		model.addAttribute("employees", employeeRepo.findAll());
		return  "employee/index";
	}	
	
	@GetMapping("/createEmployee")
	public String createEmployee(Employee employee) 
	{
		
	    return "employee/create";	
	    
	}	
	
	@PostMapping("/addEmployee")
	public String addEmployee(@Valid @ModelAttribute(name="employee") Employee employee,BindingResult result,Model model,
			 @RequestParam("fileImage") MultipartFile multipartFile) throws IOException
	{
		if (result.hasErrors()) 
		{			
          return "employee/create";
        }		
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		employee.setImage(fileName);
		Employee savedEmp = employeeRepo.save(employee);		 
        String uploadDir = "./user-photos/" + savedEmp.getId();        
        Path uploadPath=Paths.get(uploadDir);
        
        if(!Files.exists(uploadPath))
        {
        	Files.createDirectories(uploadPath);
        }
        try(InputStream inputStream=multipartFile.getInputStream())
        {
            Path filePath=uploadPath.resolve(fileName);
            System.out.println(filePath.toFile().getAbsolutePath());
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
            			
		} 
        catch (IOException e) 
        {
        	throw  new IOException("could not save upload file :"+fileName);
			
		}
        
		 employeeRepo.save(employee);
		 return "redirect:/indexEmployee";
		
	}
	
	@GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model) 
	{
		Employee employee = employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("employee", employee);    
        return "employee/edit";
    }	
	
	@PostMapping("/updateEmployee/{id}")
	public String  updateEmployee(@Valid Employee employee ,BindingResult result,@PathVariable("id") int id,Model model)
	{
		if (result.hasErrors()) 
		{
			employee.setId(id);
          return "employee/edit";
        }
		
		 employeeRepo.save(employee);		 
		 return "redirect:/indexEmployee";
		 
	}	
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String  deleteEmployee(@PathVariable("id") int id, Model model)
	{
		Employee employee=employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		employeeRepo.delete(employee);
		
		return "redirect:/indexEmployee";
	}
	
}

