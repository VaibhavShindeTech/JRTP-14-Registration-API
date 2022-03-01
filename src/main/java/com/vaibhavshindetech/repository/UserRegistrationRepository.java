package com.vaibhavshindetech.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhavshindetech.entity.UserEntity;

public interface UserRegistrationRepository extends JpaRepository<UserEntity, Serializable> {

}
