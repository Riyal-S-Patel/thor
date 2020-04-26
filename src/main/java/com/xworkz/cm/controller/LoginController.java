package com.xworkz.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.entity.RegisterEntity;
import com.xworkz.cm.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private LoginService loginService;

	public LoginController() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("userLogin.do")
	public String onLogin(LoginDTO loginDTO, Model model) {
		System.out.println("invoking onLogin....");
		String email = loginDTO.getEmail();
		System.out.println("email is :" + email);

		String password = loginDTO.getPassword();
		System.out.println("password is :" + password);

		try {
			RegisterEntity registerEntity = this.loginService.validateLogin(loginDTO, model);
			System.out.println("entity :" + registerEntity);
			if (registerEntity != null) {
				System.out.println("Email and password is valid");
				return "home";
			} else {
				System.out.println("Email and password is invalid..");
				model.addAttribute("loginmsg", "Email or Password is wrong");
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
}
