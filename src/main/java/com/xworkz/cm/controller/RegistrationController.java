package com.xworkz.cm.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.cm.dto.RegisterDTO;
import com.xworkz.cm.service.RegisterService;

@Controller
@RequestMapping("/")
public class RegistrationController {
	@Autowired
	private RegisterService registerService;

	private static final Logger logger = Logger.getLogger(RegistrationController.class);

	public RegistrationController() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("register.do")
	public String onRegister() {
		return "register";
	}

	@RequestMapping(value = "registerUser.do", method = RequestMethod.POST)
	public String onRegisterUser(RegisterDTO registerDTO, Model model) {
		logger.info("invoking onRegisterUser\t" + registerDTO);
		Map<String, Object> map = this.registerService.isValidate(registerDTO);
		boolean res = (Boolean) map.get("isValid");
		logger.info("res :" + res);
		if ((boolean) res) {
			String password = registerService.genPassNSaveData(registerDTO);
			if (password != null) {
				logger.info("data saved successfully");
				model.addAttribute("register", "register Successfully");
				model.addAttribute("password", "your Password is : " + password);
			}
		} else {
			model.addAttribute("data", map);
			logger.info("Map :" + map);
		}
		return "register";
	}

}
