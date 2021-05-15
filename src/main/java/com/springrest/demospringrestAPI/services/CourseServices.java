package com.springrest.demospringrestAPI.services;

import com.springrest.demospringrestAPI.entity.Course;

import java.util.List;

public interface CourseServices {
    public List<Course> getAllCourses();
    public Course getSingleCourseDetails(long courseId);

    public Course addCourses(Course course);

    public Course updateCourse(Course course, String courseId);

   public List<Course> deleteCourse(String courseId);
}
