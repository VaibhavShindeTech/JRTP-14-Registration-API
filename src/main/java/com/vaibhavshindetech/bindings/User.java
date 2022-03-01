package com.vaibhavshindetech.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	private String user_id;
	
	private String user_full_name;
	
	private String user_email;
	
	private String user_mobile;
	
	private String user_gender;
	
	private LocalDate user_DOB;
	
	private Long user_SSN;
	
	private LocalDate createdDate;
	
	private LocalDate updatedDate;
}
