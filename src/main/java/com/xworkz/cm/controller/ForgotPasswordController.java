package com.xworkz.cm.controller;

import org.apache.log4j.Logger;
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

	private static final Logger logger = Logger.getLogger(ForgotPasswordController.class);

	public ForgotPasswordController() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("forgotpsw.do")
	public String onForgot(ForgotPasswordDTO forgotPasswordDTO, Model model) {
		logger.info("invoking onForgot....");
		String email = forgotPasswordDTO.getEmail();
		logger.info("Email \t" + email);

		try {
			String databaseData = this.forgotPasswordService.validateEmail(forgotPasswordDTO);
			logger.info("Data from dataBase \t" + databaseData);
			if (databaseData.equals("email is not matching")) {
				model.addAttribute("email", "invalid email");
				logger.info("email is invalid....");
				return "forgotPassword";
			} else {
				model.addAttribute("email", databaseData);
				logger.info("email is valid");
				return "login";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;

	}
}
