package com.xworkz.cm.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ForgotPasswordDTO implements Serializable {
	private String email;

	private static final Logger logger = Logger.getLogger(ForgotPasswordDTO.class);

	public ForgotPasswordDTO() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}
}
