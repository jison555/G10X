package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.SecurityConfig;
import com.example.demo.entity.Students;
import com.example.demo.exception.NoDataFoundException;
import com.example.demo.service.StudentServiceImpl;

//@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServiceImpl service;

	@PostMapping(path ="/addStudent",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Students> addMarks(@RequestBody Students std) {
		Students student = service.addMarks(std);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}

	@GetMapping("/getStudent")
	public Students getMark(@RequestParam Integer id) {
		Students Mark = service.getMark(id);
		return Mark;
	}

	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Students>> getAllMark() {
		List<Students> students = service.getAllMark();
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		return ResponseEntity.status(HttpStatus.OK).body(students);
	}

	@PutMapping("/updateStudent")
	public String updateMarks(@RequestBody Students std) {
		service.updateMarks(std);
		return "updated";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteMarks(@PathVariable int id) {
		service.deleteMarks(id);
		return "successfully deleted";
	}
//================================================================================

	@GetMapping("/favSub")
	public List<Students> findbyFavSub(@RequestParam String sub) {
		return service.findbyFavSub(sub);
	}

//===============================custom query==============================================

	@GetMapping("/studentByIdGreaterThan/{id}")
	public List<Students> findbyFavSub(@PathVariable int id) {
		return service.findbyFavSub(id);
	}

	@PutMapping("/updateSubById")
	@Transactional
	public void updateSubById(@RequestParam String sub, int id) {
		try {
			service.updateSubById(sub, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

//=========================Exception Handling==================================================
	@GetMapping("/exception")
	public Students addMarks() throws NoDataFoundException {
		throw new NoDataFoundException();
	}
}
