package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Students;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo studentRepo;

	@Override
	public Students addMarks(Students std) {
		Students opt = studentRepo.save(std);
		return opt;
	}

	@Override
	public Students getMark(Integer id) {
		Optional<Students> optMark = studentRepo.findById(id);
		return optMark.orElse(new Students());
	}

	@Override
	public List<Students> getAllMark() {
		Iterable<Students> iterable = studentRepo.findAll();
		List<Students> list = new ArrayList<>();
		Iterator<Students> it = iterable.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	@Override
	public String updateMarks(Students std) {
		studentRepo.save(std);
		return "updated";
	}

	@Override
	public String deleteMarks(int id) {
		studentRepo.deleteById(id);
		return "successfully deleted";
	}

	@Override
	public List<Students> findbyFavSub(String sub) {
		return studentRepo.findByFavSubject(sub);
	}

	@Override
	public List<Students> findbyFavSub(int id) {
		return studentRepo.findByIdGreaterThan(id);
	}

	@Override
	public void updateSubById(String sub, int id) {
		try {
		studentRepo.updateById(sub, id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
}
