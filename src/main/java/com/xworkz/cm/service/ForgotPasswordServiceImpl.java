package com.xworkz.cm.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.cm.dao.ForgotPasswordDAO;
import com.xworkz.cm.dto.ForgotPasswordDTO;
import com.xworkz.cm.entity.RegisterEntity;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
	@Autowired
	private ForgotPasswordDAO forgotPasswordDAO;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public ForgotPasswordServiceImpl() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public String validateEmail(ForgotPasswordDTO forgotPasswordDTO) {
		System.out.println("invoking validateEmail...");
		try {
			RegisterEntity registerEntity = this.forgotPasswordDAO.getByEmail(forgotPasswordDTO.getEmail());
			System.out.println("RegisterEntity in ForgotPasswordServiceImpl \t" + registerEntity);
			if (registerEntity == null) {
				return "email not matching";
			}
			int id = registerEntity.getId();
			System.out.println("Id From DB \t" + id);
			int count = 0;
			if (registerEntity != null) {
				String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
				String pswd = "";
				int length = 8;

				Random random = new Random();
				char[] psw = new char[length];
				for (int i = 0; i < length; i++) {
					psw[i] = chars.charAt(random.nextInt(chars.length()));
				}
				for (int i = 0; i < length; i++) {
					pswd += psw[i];
				}
				System.out.println("Password Generated \t" + pswd);
				registerEntity.setPassword(bCryptPasswordEncoder.encode(pswd));
				registerEntity.setCount(count);
				System.out.println("Count is \t" + count);
				this.forgotPasswordDAO.updatePassword(bCryptPasswordEncoder.encode(pswd), count, id);
				return "your new password is :" + pswd + " use this password to login again";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "email not matching";
		}
		return "email is not matching";
	}

}
