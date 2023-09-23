package com.example.servicesCourseBatchStd;

import java.util.List;
import java.util.Optional;

import com.example.demo.*;
import com.example.entityCourseBatchStd.Course;
import com.example.repositoryCourseBatchStd.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseMangerImpl implements CourseManager 
{
	@Autowired
	CourseRepository repository;
	
	@Override
	public void addCourse(Course c) {
		// TODO Auto-generated method stub
		repository.save(c);
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	
	@Override
	public void update(Course course, int id) {
		// TODO Auto-generated method stub
		repository.update(course.getCourse_name(),course.getCourse_description(),course.getCourse_duration(),course.getCourse_syllabus(),course.getAge_grp_type(),course.isCourse_is_active(),course.getCover_photo(),course.getVideo_id(),id);
	
	}

	@Override
	public Optional<Course> getCourse(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void statusInactive(boolean status , int cid) {
		// TODO Auto-generated method stub
		repository.updateInactive(status,cid);
	}



}
