package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145, "Java Core Course", "This is a course on the basics of Java"));
		list.add(new Course(237, "Spring Boot Course", "This is a course on creating REST APIs using Spring Boot"));
	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for (Course course : list) {
			if (course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(item -> {
			if (item.getId() == course.getId()) {
				item.setTitle(course.getTitle());
				item.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		list = this.list.stream().filter(item -> item.getId() != courseId).collect(Collectors.toList());
	}

}
