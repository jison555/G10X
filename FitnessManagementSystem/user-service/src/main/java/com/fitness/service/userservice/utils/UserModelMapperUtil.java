package com.fitness.service.userservice.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fitness.service.userservice.entity.UserEntity;
import com.fitness.service.userservice.model.UserModel;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserModelMapperUtil {

	
	private ModelMapper modelMapper;
	
	@PostConstruct
	private void createModelInstance() {
		System.out.println("model mapper before initialize = "+this.modelMapper);
		modelMapper = new ModelMapper();
		System.out.println("model mapper after initialize = "+this.modelMapper);
	}
	

	
	public UserEntity convertUserModelToEntity(UserModel userModel) {
		return modelMapper.map(userModel, UserEntity.class);
	}
	
	public UserModel convertUserEntityToModel(UserEntity userEntity) {
		return modelMapper.map(userEntity, UserModel.class);
	}

}
