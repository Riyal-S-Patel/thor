package com.xworkz.cm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.cm.dao.LoginDAO;
import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.entity.RegisterEntity;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

	public LoginServiceImpl() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity validateLogin(LoginDTO loginDTO, Model model) {
		logger.info("invoking validateLogin()....");
		try {
			// RegisterEntity entity = this.loginDAO.getEmailAndPassword(loginDTO);
			RegisterEntity entity = this.loginDAO.getByEmail(loginDTO.getEmail());
			if (entity != null) {
				if (bCryptPasswordEncoder.matches(loginDTO.getPassword(), entity.getPassword())) {
					if (entity.getCount() < 4 && entity.getCount() >= 0) {
						if (entity.getCount() != 0) {
							this.loginDAO.updateCountByEmail(0, entity.getEmail());
							logger.info("user Count is Updated by 0");
						}
						logger.info("email and password is valid");
						return entity;
					} else {
						logger.info("Register User is blocked");
						model.addAttribute("block", "Register User is blocked");
						return null;
					}

				} else if (!bCryptPasswordEncoder.matches(loginDTO.getPassword(), entity.getPassword())) {
					if (entity.getCount() < 4) {
						entity.setCount(entity.getCount() + 1);
						this.loginDAO.updateCountByEmail(entity.getCount(), entity.getEmail());
					}
					if (entity.getCount() > 3) {
						logger.info("Register user is blocked");
						model.addAttribute("block", "Register User is blocked");
					}
					logger.info("email and password is not valid");
					return null;
				}
			} else {
				logger.info("email is not present");
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

}
