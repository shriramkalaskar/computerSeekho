package com.example.servicesCourseBatchStd;

import java.util.List;
import java.util.Optional;

import com.example.entityCourseBatchStd.Course;


public interface CourseManager
{
	void addCourse(Course c);
	List<Course> getCourses();
	void delete(int id);
	void update(Course Course,int id);
	Optional<Course> getCourse(int id);
	void statusInactive(boolean status, int cid);
	 
	 
	 
}