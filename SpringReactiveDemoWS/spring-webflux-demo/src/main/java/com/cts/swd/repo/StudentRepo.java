package com.cts.swd.repo;

import java.util.List;

import com.cts.swd.model.Student;

public interface StudentRepo {
	List<Student> getAll();
	Student getById(Long sid);
	Student add(Student student);
}
