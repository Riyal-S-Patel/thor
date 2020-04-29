package com.xworkz.cm.service;

import org.springframework.ui.Model;

import com.xworkz.cm.dto.ForgotPasswordDTO;

public interface ForgotPasswordService {
	public String validateEmail(ForgotPasswordDTO forgotPasswordDTO);
}
