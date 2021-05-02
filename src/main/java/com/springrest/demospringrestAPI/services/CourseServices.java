package com.springrest.demospringrestAPI.services;

import com.springrest.demospringrestAPI.entity.Course;

import java.util.List;

public interface CourseServices {
    public List<Course> getCourses();
    public Course getCourse(long courseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

   public List<Course> deleteCourse(String courseId);
}
