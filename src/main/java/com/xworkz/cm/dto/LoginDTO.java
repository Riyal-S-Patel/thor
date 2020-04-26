package com.xworkz.cm.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO implements Serializable {
	private String email;
	private String password;

	public LoginDTO() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}
}
