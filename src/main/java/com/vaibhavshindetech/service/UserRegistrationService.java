package com.vaibhavshindetech.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vaibhavshindetech.bindings.User;
import com.vaibhavshindetech.bindings.UserResponse;
import com.vaibhavshindetech.entity.UserEntity;

public interface UserRegistrationService {
	public UserResponse saveUser(User user);
	public Page<UserEntity> getAllUser(Integer pageNum);
}
