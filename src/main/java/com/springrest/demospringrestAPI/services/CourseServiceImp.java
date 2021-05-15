package com.springrest.demospringrestAPI.services;

import com.springrest.demospringrestAPI.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImp implements CourseServices{

    List<Course> list;
    public CourseServiceImp(){
        list=new ArrayList<>();
        list.add(new Course(12,"java core course","this course contains basic of java"));
        list.add(new Course(14,"spring boot course","creating rest api using spring boot"));
    }

    @Override
    public List<Course> getAllCourses() {
        return list;
    }

    @Override
    public Course getSingleCourseDetails(long courseId) {

        Course c=null;
        for (Course course:list){
            if (course.getId()==courseId){
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourses(Course course) {
         list.add(course);
         return course;
    }

    @Override
    public Course updateCourse(Course course, String courseId) {
        Course temp = null;

       for(Course courseVar : list) {
           if (courseVar.getId() == Integer.parseInt(courseId)) {
               courseVar.setDescription(course.getDescription());
               courseVar.setTitle(course.getTitle());
               temp=courseVar;
               break;
           }
       }
        return temp;
    }

    @Override
    public List<Course> deleteCourse(String courseId) {

        for (Course courseVar:list){
            if (courseVar.getId()==Integer.parseInt(courseId)){
                list.remove(courseVar);
            }
        }
        return list;
    }


}
