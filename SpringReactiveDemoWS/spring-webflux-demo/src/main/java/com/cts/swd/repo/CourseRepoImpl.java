package com.cts.swd.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.cts.swd.model.Course;

@Repository
public class CourseRepoImpl implements CourseRepo{

	private Map<Long, Course> coursesMap;
	
	public CourseRepoImpl() {
		this.coursesMap= new TreeMap<>();
		this.coursesMap.put(101L, new Course(101L, "Spring Boot",5400.0));
		this.coursesMap.put(102L, new Course(102L, "Spring WebMvc",3400.0));
		this.coursesMap.put(103L, new Course(103L, "Spring WebRest",9400.0));
		this.coursesMap.put(104L, new Course(104L, "Spring WebFlux",5400.0));
	}
	
	private long getNewCourseId() {
		long cid=101;
		if(coursesMap!=null && !coursesMap.isEmpty()) {
			cid=coursesMap.keySet().stream().map(c -> (long)c).reduce((cid1,cid2) -> (cid1>cid2?cid1:cid2)).orElse(100L) +1;
		}
		return cid;
	}
	
	@Override
	public List<Course> getAll() {
		//return new ArrayList<>(this.coursesMap.values());
		return this.coursesMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public Course getById(Long cid) {
		return this.coursesMap.get(cid);
	}

	@Override
	public Course add(Course course) {
		if(course!=null) {
			long cid = getNewCourseId();
			course.setCid(cid);
			this.coursesMap.put(cid, course);
		}
		return course;
	}

}
