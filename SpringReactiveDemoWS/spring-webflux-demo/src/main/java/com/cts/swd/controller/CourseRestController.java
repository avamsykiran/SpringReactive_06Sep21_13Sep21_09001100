package com.cts.swd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.swd.model.Course;
import com.cts.swd.service.CourseService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseRestController {

	@Autowired
	private CourseService service;
	
	@GetMapping
	public Flux<Course> defautltGetAction(){
		return this.service.getAll();
	}
	
	@GetMapping("/{cid}")
	public Mono<Course> getByIdAction(@PathVariable("cid")Long cid){
		return this.service.getById(cid);
	}
	
	@PostMapping
	public Mono<Course> addCourseAction(@RequestBody Course course){
		return this.service.add(course);
	}
}
