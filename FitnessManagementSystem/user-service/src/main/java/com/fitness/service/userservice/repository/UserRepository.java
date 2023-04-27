package com.fitness.service.userservice.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitness.service.userservice.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public List<UserEntity> findByMobNo(Long mobNo);
	public List<UserEntity> findByTrainer(Long trainer);
	
//	@Query("select * from userentity where mobno like %")
//	public UserEntity getMobEndsWith();

}
