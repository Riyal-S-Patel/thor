package com.xworkz.cm.dao;

import com.xworkz.cm.entity.RegisterEntity;

public interface ForgotPasswordDAO {
	public int updatePassword(String password, int count, int id);

	public RegisterEntity getByEmail(String email);
}
