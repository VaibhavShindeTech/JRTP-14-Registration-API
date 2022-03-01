package com.vaibhavshindetech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vaibhavshindetech.bindings.User;
import com.vaibhavshindetech.bindings.UserResponse;
import com.vaibhavshindetech.constants.AppConstant;
import com.vaibhavshindetech.entity.UserEntity;
import com.vaibhavshindetech.props.AppProps;
import com.vaibhavshindetech.repository.UserRegistrationRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	@Autowired
	private AppProps appProps;

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public UserResponse saveUser(User user) {
		String status = appProps.getMessages().get(AppConstant.fail);
		UserResponse userResponse = new UserResponse();
		Long ssn = user.getUser_SSN();
		String url = appProps.getMessages().get(AppConstant.ssn_web_url);
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, ssn);
		String stateName = response.getBody().toLowerCase();
		if (stateName.equals(AppConstant.state_name)) {
			UserEntity userEntity = new UserEntity();
			BeanUtils.copyProperties(user, userEntity);
			userRegistrationRepository.save(userEntity);
			status = appProps.getMessages().get(AppConstant.success);
			userResponse.setApplicationId(userEntity.getUser_id());
			userResponse.setStatus(status);
			return userResponse;
		} else {
			userResponse.setApplicationId(null);
			userResponse.setStatus(status);
			return userResponse;
		}
	}

	@Override
	public Page<UserEntity> getAllUser(Integer pageNum) {
		PageRequest pageRequest=PageRequest.of(pageNum, 8);
//		List<UserEntity> userEntityList = 
				Page<UserEntity> page = userRegistrationRepository.findAll(pageRequest);
		List<User> userList = new ArrayList<User>();
//		for (UserEntity userEntity : userEntityList) {
//			User user = new User();
//			BeanUtils.copyProperties(userEntity, user);
//			userList.add(user);
//		}
		return page;
	}

}
