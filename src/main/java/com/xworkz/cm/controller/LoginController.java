package com.xworkz.cm.controller;

import org.apache.log4j.Logger;
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

	private static final Logger logger = Logger.getLogger(LoginController.class);

	public LoginController() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("userLogin.do")
	public String onLogin(LoginDTO loginDTO, Model model) {
		logger.info("invoking onLogin....");
		String email = loginDTO.getEmail();
		logger.info("email is :" + email);
		String password = loginDTO.getPassword();
		logger.info("password is :" + password);
		try {
			RegisterEntity registerEntity = this.loginService.validateLogin(loginDTO, model);
			logger.info("entity :" + registerEntity);
			if (registerEntity != null) {
				logger.info("Email and password is valid");
				return "home";
			} else {
				logger.info("Email and password is invalid..");
				model.addAttribute("loginmsg", "Email or Password is wrong");
				return "login";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "login";
	}
}
