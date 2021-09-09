package com.cts.swd.service;

import com.cts.swd.model.Student;

import reactor.core.publisher.Flux;

public interface StudentService {
	Flux<Student> getAll();
	Flux<Student> getAllByCourse(Long cid);
	Student getById(Long sid);
	Student addStudent(Student student);
}
