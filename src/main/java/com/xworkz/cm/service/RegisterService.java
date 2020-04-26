package com.xworkz.cm.service;

import java.util.Map;

import com.xworkz.cm.dto.RegisterDTO;

public interface RegisterService {
	public Map<String, Object> isValidate(RegisterDTO registerDTO);

	public String genPassNSaveData(RegisterDTO registerDTO);
}
