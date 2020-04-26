package com.xworkz.cm.service;

import org.springframework.ui.Model;

import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.entity.RegisterEntity;

public interface LoginService {
	public RegisterEntity validateLogin(LoginDTO loginDTO,Model model);
}
