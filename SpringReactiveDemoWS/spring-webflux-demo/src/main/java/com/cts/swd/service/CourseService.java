package com.cts.swd.service;

import com.cts.swd.model.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

	Flux<Course> getAll();
	Mono<Course> getById(long cid);
	Mono<Course> add(Course course);
}
