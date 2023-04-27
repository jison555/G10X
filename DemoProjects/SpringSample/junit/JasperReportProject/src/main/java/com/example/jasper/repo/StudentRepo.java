package com.example.jasper.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jasper.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
