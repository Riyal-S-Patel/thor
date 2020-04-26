package com.xworkz.cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.cm.dao.LoginDAO;
import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.entity.RegisterEntity;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public LoginServiceImpl() {
		System.out.println("created \t " + this.getClass().getSimpleName());
	}

	public RegisterEntity validateLogin(LoginDTO loginDTO, Model model) {
		System.out.println("invoking validateLogin()....");
		try {
			// RegisterEntity entity = this.loginDAO.getEmailAndPassword(loginDTO);
			RegisterEntity entity = this.loginDAO.getByEmail(loginDTO.getEmail());
			if (entity != null) {
				if (entity.getPassword().equals(loginDTO.getPassword())) {
					if (entity.getCount() < 4 && entity.getCount() >= 0) {
						if (entity.getCount() != 0) {
							 this.loginDAO.updateCountByEmail(0, entity.getEmail() );
							System.out.println("user Count is Updated by 0");
						}
						System.out.println("email and password is valid");
						return entity;
					} else {
						System.out.println("Register User is blocked");
						model.addAttribute("block", "Register User is blocked");
						return null;
					}

				} else if (!entity.getPassword().equals(loginDTO.getPassword())) {
					if (entity.getCount() < 4) {
						entity.setCount(entity.getCount()+1);
						 this.loginDAO.updateCountByEmail(entity.getCount(),entity.getEmail());
					}if(entity.getCount()>3) {
						System.out.println("Register user is blocked");
						model.addAttribute("block", "Register User is blocked");
					}
					System.out.println("email and password is not valid");
					return null;
				}
			} else {
				System.out.println("email is not present");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
