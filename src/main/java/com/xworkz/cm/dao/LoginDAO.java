package com.xworkz.cm.dao;

import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.entity.RegisterEntity;

public interface LoginDAO {
	public RegisterEntity getEmailAndPassword(LoginDTO loginDTO);

	public RegisterEntity getByEmail(String email);

	public void updateCountByEmail(int count, String email);
}
