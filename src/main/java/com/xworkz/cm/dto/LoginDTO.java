package com.xworkz.cm.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO implements Serializable {
	private String email;
	private String password;

	private static final Logger logger = Logger.getLogger(LoginDTO.class);

	public LoginDTO() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}
}
