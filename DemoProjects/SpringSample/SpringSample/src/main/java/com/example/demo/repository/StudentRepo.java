package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Students;

@Repository
public interface StudentRepo extends CrudRepository<Students, Integer> {

	List<Students> findByFavSubject(String fav);
	
	@Query("from Students where id>?1 order by favSubject")
	List<Students> findByIdGreaterThan(int id);
	
	@Modifying
	@Query("update Students set favSubject=?1 where id=?2")
	void updateById(String sub , int id);
	
}
	