package com.xworkz.cm.dto;

import java.io.Serializable;
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

	public RegisterDTO() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}
}
