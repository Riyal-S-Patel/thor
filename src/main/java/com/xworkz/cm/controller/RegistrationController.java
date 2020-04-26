package com.xworkz.cm.controller;

import java.util.Map;

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

	public RegistrationController() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("register.do")
	public String onRegister() {
		return "register";
	}

	@RequestMapping(value = "registerUser.do", method = RequestMethod.POST)
	public String onRegisterUser(RegisterDTO registerDTO, Model model) {
		System.out.println("invoking onRegisterUser\t" + registerDTO);
		Map<String, Object> map = this.registerService.isValidate(registerDTO);
		boolean res = (Boolean) map.get("isValid");
		System.out.println("res :" + res);
		if ((boolean) res) {
			String password = registerService.genPassNSaveData(registerDTO);
			if (password != null) {
				System.out.println("data saved successfully");
				model.addAttribute("register", "register Successfully");
				model.addAttribute("password", "your Password is : " + password);
			}
		} else {
			model.addAttribute("data", map);
			System.out.println("Map :" + map);
		}
		return "register";
	}

}
