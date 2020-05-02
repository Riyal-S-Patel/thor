package com.xworkz.cm.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterDTO implements Serializable {
	private int id;
	private String userId;
	private String email;
	private Long phoneNo;
	private String password;
	private String isAgree;
	private String courseType;

	private static final Logger logger = Logger.getLogger(RegisterDTO.class);

	public RegisterDTO() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}
}
