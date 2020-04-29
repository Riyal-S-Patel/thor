package com.xworkz.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.cm.dto.ForgotPasswordDTO;
import com.xworkz.cm.service.ForgotPasswordService;

@Controller
@RequestMapping("/")
public class ForgotPasswordController {
	@Autowired
	private ForgotPasswordService forgotPasswordService;

	public ForgotPasswordController() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}
	@RequestMapping("forgotpsw.do")
	public String onForgot(ForgotPasswordDTO forgotPasswordDTO, Model model) {
		System.out.println("invoking onForgot....");
		
		String email=forgotPasswordDTO.getEmail();
		System.out.println("Email \t"+email);
		
		try {
			String databaseData=this.forgotPasswordService.validateEmail(forgotPasswordDTO);
			System.out.println("Data from dataBase \t"+databaseData);
			
			if(databaseData.equals("email is not matching")) {
				model.addAttribute("email", "invalid email");
				System.out.println("email is invalid....");
				return "forgotPassword";
			}else {
				model.addAttribute("email", databaseData);
				System.out.println("email is valid");
				return "login";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
