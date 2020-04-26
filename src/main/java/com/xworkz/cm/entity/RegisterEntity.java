package com.xworkz.cm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "registration_details")
public class RegisterEntity implements Serializable {

	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "ID")
	private int id;
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE_NO")
	private Long phoneNo;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "AGREE")
	private String isAgree;
	@Column(name = "COURSE_TYPE")
	private String courseType;
	@Column(name = "COUNT")
	private int count;

	public RegisterEntity() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}
}
