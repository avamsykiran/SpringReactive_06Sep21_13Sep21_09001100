package com.cts.swd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.swd.model.Course;
import com.cts.swd.repo.CourseRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo repo;

	@Override
	public Flux<Course> getAll() {
		List<Course> courses = repo.getAll();
		return courses == null || courses.isEmpty() ? Flux.error(() -> (new Exception("No Data Feteched")))
				: Flux.fromIterable(courses);
	}

	@Override
	public Mono<Course> getById(long cid) {
		Course course = repo.getById(cid);
		return course != null ? Mono.just(course) : Mono.error(() -> (new Exception("Resource Not found")));
	}

	@Override
	public Mono<Course> add(Course course) {
		return Mono.just(repo.add(course));
	}

}
