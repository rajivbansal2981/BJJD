package com.jmk.bjjd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmk.bjjd.models.UserModel;

@Controller("accessController")
public class AccessController {

	@RequestMapping("/login")
	public String login(@ModelAttribute("userModel")UserModel userModel,@RequestParam(required=false)String message){
		return "login";
	}
	
	@RequestMapping(value="/")
	public String home(){
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login/failure")
	public String loginFailure(){
		String message="Login Failure";
		return "redirect:/login?message="+message;
	}
	
	@RequestMapping(value="/logout/success")
	public String logoutSuccess(){
		String message="Logout Success";
		return "redirect:/login?message="+message;
	}
	
	@RequestMapping("/home")
	public String getHomePage(){
		return "home";
	}
	
}