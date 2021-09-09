package com.cts.swd.repo;

import java.util.List;

import com.cts.swd.model.Course;

public interface CourseRepo {
	List<Course> getAll();
	Course getById(Long cid);
	Course add(Course course);
}
