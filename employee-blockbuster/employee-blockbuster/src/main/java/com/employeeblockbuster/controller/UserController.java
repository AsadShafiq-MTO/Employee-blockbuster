package com.employeeblockbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.employeeblockbuster.service.UserService;

@Controller
//@RequestMapping("/user")
public class UserController {

	
	@Autowired 
	private UserService userService;  
	  
		/*
		 * @ModelAttribute private void userDetails(Model m, Principal p) { String email
		 * = p.getName(); UserDtls user = userService.findByEmails(email);
		 * 
		 * m.addAttribute("users", user); }
		 */
	 
	
//	@GetMapping("/asad")
//	public String fragment()
//	{
//		
//		return  "fragment/base";
//	}	
//	
//	@GetMapping("/asad1")
//	public String host()
//	{
//		return "fragment/index";
//	}
//	@GetMapping("/asad2")
//	public String chart()
//	{
//		return "tempo/charts";
//	}
//	@GetMapping("/asad3")
//	public String layoutSidenavLight()
//	{
//		return "tempo/layout-sidenav-light";
//	}
//	@GetMapping("/asad4")
//	public String layoutStatic()
//	{
//		return "tempo/layout-static";
//	}
//	@GetMapping("/asad5")
//	public String table()
//	{
//		return "tempo/tables";
//	}

}