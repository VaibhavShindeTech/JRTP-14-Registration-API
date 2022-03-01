package com.vaibhavshindetech.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "INSURANCE_USER_DTLS")
@Data
public class UserEntity {
	@Id
	@GenericGenerator(name = "user_id_gen", strategy = "com.vaibhavshindetech.idgenerator.UserIdGenerator")
	@GeneratedValue(generator = "user_id_gen")
	@Column(name = "USER_ID")
	private String user_id;

	@Column(name = "USER_FULL_NAME")
	private String user_full_name;

	@Column(name = "USER_EMAIL")
	private String user_email;

	@Column(name = "USER_MOBILE")
	private String user_mobile;

	@Column(name = "USER_GENDER")
	private String user_gender;

	@Column(name = "USER_DOB")
	private LocalDate user_DOB;

	@Column(name = "USER_SSN")
	private Long user_SSN;

	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;

	@Column(name = "UPDATED_DATE")
	@CreationTimestamp
	private LocalDate updatedDate;
}
