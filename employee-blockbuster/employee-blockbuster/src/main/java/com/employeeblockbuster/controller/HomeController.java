package com.employeeblockbuster.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeeblockbuster.config.Message;
import com.employeeblockbuster.model.UserDtls;
import com.employeeblockbuster.service.UserService;

@Controller
public class HomeController {
	
	@Autowired 
	private UserService userService;
		
	@GetMapping("/indexSignup")
	public String indexSignup(Model model)
	{
		model.addAttribute("title","Home -employee blockbuster");
		model.addAttribute("users", userService.findAll());
		return  "user/indexSignup";
	}
	
	
	@GetMapping("/")
	public String dashbord(Model model)
	{
		model.addAttribute("title","Home -employee blockbuster");
		return "tempo/index";
	}
	
	@GetMapping("/forgotPassword")
	public String logout(Model model)
	{
		model.addAttribute("title","ForgotPassword -employee blockbuster");
		return "tempo/password";
	}
		
	@GetMapping("/signin")
	public String login(Model model)
	{
		model.addAttribute("title","Login -employee blockbuster");
		return "tempo/login";
	}	
	
	@GetMapping("/register")
	public String register(Model model)       /// UserDtls user,Model model
	{
		model.addAttribute("title","Register -employee blockbuster");
        model.addAttribute("user", new UserDtls());
        return "tempo/register";
	}	
	@SuppressWarnings("unused")
	@PostMapping("/createUser")
	public String createuser(@Valid @ModelAttribute("user") UserDtls user,BindingResult result,
	                          @RequestParam(value = "agreement",defaultValue = "false")boolean agreement,
	                          Model model, HttpSession session) 
	{
		try 
		{
			boolean f = userService.checkEmail(user.getEmail());
			if (f)
			{						
				session.setAttribute("message",new Message("Email Id alreday exists", "alert-danger"));
				return "redirect:/register";
			}	
			
			if(!agreement)
			{
				System.out.println(" You have not agreed the term and condition");
				throw new Exception(" You have not agreed the term and condition");
			}	
			
			if (result.hasErrors()) 
			{
				System.out.println("ERROR"+result.toString());
				model.addAttribute("user", user);
				return "tempo/register";
		    }
			
			System.out.println("Agreement " +agreement);
			System.out.println("USER"+user);		
			UserDtls resDtls=userService.createUser(user);			
			model.addAttribute("user", new UserDtls());				
			session.setAttribute("message",new Message("Successfully Registered !!", "alert-success"));			
			return "tempo/login";
			 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something went wrong !!"+e.getMessage(),"alert-danger"));
			return "tempo/register";
		}	
	  }
}
	
	
	
	
	
	
	
	
	


	
//	@PostMapping("/createUser")
//	public String createuser(@ModelAttribute UserDtls user, HttpSession session) 
//	{
//		boolean f = userService.checkEmail(user.getEmail());
//		if (f)
//		{
//			session.setAttribute("msg", "Email Id alreday exists");
//			return "redirect:/register";
//		}	
//				
//		else 
//		{
//			UserDtls userDtls = userService.createUser(user);
//			if (userDtls != null)
//			{
//				session.setAttribute("msg", "Register Sucessfully");
//				
//				/*
//				 * if (!StringUtils.isEmpty(user.getPassword())) 
//				 * {
//				 * user.setPassword(passwordEncoder.encode(user.getPassword())); 
//				 * }
//				 * model.addAttribute("user", user);
//				 */		     				
//			} 
//			else 
//			{
//				session.setAttribute("msg", "Something wrong on server");
//			}
//			return "redirect:/signin";
//		}		
//	}
    


	
	
	

