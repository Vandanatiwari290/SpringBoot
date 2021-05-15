package com.springrest.demospringrestAPI.Controller;

import com.springrest.demospringrestAPI.entity.Course;
import com.springrest.demospringrestAPI.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseServices courseServices;

    /**
     * get the list of all courses
     * @return
     */

    @GetMapping("/courses")
    public List<Course>getAllCourses(){
        return this.courseServices.getAllCourses();

    }

    /***
     * get the particular course details based on course id
     * @param courseId
     * @return
     */
    @GetMapping("/course")
    public Course getCourse(@RequestParam String courseId){
       return this.courseServices.getSingleCourseDetails(Long.parseLong(courseId));
    }


    /***
     * add the new course
     */
    @PostMapping("/addCourses")
    public Course addCourse(@RequestBody Course course){
        return this.courseServices.addCourses(course);
    }

    /***
     * update the course based on course id
     * @param courseId
     * @param course
     * @return
     */

    @PutMapping("/courses/{courseId}")
    public Course updateCourses(@PathVariable String courseId, @RequestBody Course course){
        return  this.courseServices.updateCourse(course, courseId);
    }

    /****
     * delete the course details
     * @param courseId
     * @return
     */
    @DeleteMapping("/courses/{courseId}")
    public List<Course> deleteCourse(@PathVariable String courseId){
        return this.courseServices.deleteCourse(courseId);
    }
}
