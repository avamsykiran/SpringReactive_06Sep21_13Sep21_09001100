package com.cts.swd.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.swd.model.Student;

@Repository
public class StudentRepoImpl implements StudentRepo{

	@Autowired
	private CourseRepo courseRepo;
	
	private Map<Long,Student> studentsMap;
	
	public StudentRepoImpl() {
		this.studentsMap=new TreeMap<>();
		this.studentsMap.put(101L, new Student(101L, "Vamsy Kiran", "vamsy.kiran@iiht.com", LocalDate.now(),courseRepo.getById(101L)));
		this.studentsMap.put(102L, new Student(102L, "Suseela", "suseela@gmail.com", LocalDate.now(),courseRepo.getById(101L)));
		this.studentsMap.put(103L, new Student(103L, "Rama", "rama@gmail.com", LocalDate.now(),courseRepo.getById(101L)));
		this.studentsMap.put(104L, new Student(104L, "Sita", "sita@gmail.com", LocalDate.now(),courseRepo.getById(102L)));
		this.studentsMap.put(105L, new Student(105L, "Laskhman", "lucky@gmail.com", LocalDate.now(),courseRepo.getById(102L)));
		this.studentsMap.put(106L, new Student(106L, "Bharat", "bharat@gmail.com", LocalDate.now(),courseRepo.getById(103L)));
		this.studentsMap.put(107L, new Student(107L, "Shtrugnya", "Agnya@gmail.com", LocalDate.now(),courseRepo.getById(103L)));
		this.studentsMap.put(108L, new Student(108L, "Cheranjeevi", "chiru@gmail.com", LocalDate.now(),courseRepo.getById(104L)));
		this.studentsMap.put(109L, new Student(109L, "Vibhishan", "lanka@gmail.com", LocalDate.now(),courseRepo.getById(104L)));
	}

	private long getNewStudentId() {
		long sid=101;
		if(studentsMap!=null && !studentsMap.isEmpty()) {
			sid=studentsMap.keySet().stream().map(s -> (long)s).reduce((sid1,sid2) -> (sid1>sid2?sid1:sid2)).orElse(100L) +1;
		}
		return sid;
	}
	
	@Override
	public List<Student> getAll() {
		return studentsMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public Student getById(Long sid) {
		return studentsMap.get(sid);
	}

	@Override
	public Student add(Student student) {
		if(student!=null) {
			long sid = this.getNewStudentId();
			student.setAdmNo(sid);
			this.studentsMap.put(sid, student);
		}
		return student;
	}

}
