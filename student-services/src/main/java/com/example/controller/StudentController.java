package com.example.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.model.Course;
import com.example.service.StudentService;

@RestController()
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/students/{studentId}/courses")
	public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
		return studentService.retrieveCourses(studentId);
	}
	
	@RequestMapping("/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable String studentId,
			@PathVariable String courseId) {
		return studentService.retrieveCourse(studentId, courseId);
	}
	
//	@RequestMapping(value = "/students/{studentId}/courses", method = RequestMethod.POST)
//	public ResponseEntity<Void> registerStudentForCourse(
//			@PathVariable String studentId, @RequestBody Course newCourse) {
//
//		Course course = studentService.addCourse(studentId, newCourse);
//
//		if (course == null)
//			return ResponseEntity.noContent().build();
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
//				"/{id}").buildAndExpand(course.getId()).toUri();
//
//		return ResponseEntity.created(location).build();
//	}

}
