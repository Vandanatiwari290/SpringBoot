package com.springrest.demospringrestAPI;

import com.springrest.demospringrestAPI.Controller.MyController;
import com.springrest.demospringrestAPI.entity.Course;
import com.springrest.demospringrestAPI.services.CourseServices;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MyController.class)
public class UnitTest {
    @Autowired
    private  MyController myController;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CourseServices courseServices;


    @Test
    public void getAllCoursesTest() throws Exception {
        /***
         * mock the data returned by the CourseService class and then create mock http request to verify the result
         */
        Course course=new Course();

        course.setId(12);
        course.setTitle("MockMVC");
        course.setDescription("beginning of learning test rest api using mockMVC and webMvcTest");

        Mockito.when(courseServices.getAllCourses()).thenReturn(Lists.list(course));
        mockMvc.perform(MockMvcRequestBuilders.get("/courses"))
               // .andExpect(MockMvcResultMatchers.content().json(String.valueOf(course)))
                .andExpect(MockMvcResultMatchers.jsonPath("$..id").value(12))
                .andExpect(MockMvcResultMatchers.jsonPath("$..title").value("MockMVC"))
                .andExpect(MockMvcResultMatchers.jsonPath("$..description").value("beginning of learning test rest api using mockMVC and webMvcTest"))
                .andExpect(status().isOk());






    }
}
