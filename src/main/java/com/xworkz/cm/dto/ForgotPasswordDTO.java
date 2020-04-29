package com.xworkz.cm.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ForgotPasswordDTO implements Serializable {
	private String email;

	public ForgotPasswordDTO() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}
}
