package com.springrest.springrestdemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrestdemo.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<Course>();
		list.add(new Course(145,"Core Java","Basic java course"));
		list.add(new Course(150,"Spring boot course","creating Spring boot api"));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
	
	@Override
	public Course getCourse(long courseId) {
		for(Course c:list){
			if(c.getId()==courseId)
				return c;
		}
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		long courseId = course.getId();
		list.forEach( c -> { 
				if(c.getId() == courseId) {
					c.setTitle(course.getTitle());
					c.setDescription(course.getDescription());
				}
		});
		return course;
		/*for(Course c:list){
			if(c.getId()==courseId) {
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
				return c;
			}
		}
		return null;*/
	}
	
	@Override
	public void deleteCourse(long courseId) {
		list = this.list.stream().filter(e -> e.getId()!=courseId).collect(Collectors.toList());
		/*for(Course c:list){
			if(c.getId()==courseId) {
				list.remove(c.hashCode());
			}
		}*/
	}

}
