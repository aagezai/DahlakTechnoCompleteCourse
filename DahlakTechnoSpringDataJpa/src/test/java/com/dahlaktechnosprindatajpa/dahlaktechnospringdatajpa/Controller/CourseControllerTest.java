package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Controller;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Course;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Student;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Teacher;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.CourseServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
@WebMvcTest(CourseController.class)

class CourseControllerTest {
    @MockBean
    private CourseServiceImpl courseServiceImpl;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private Course course1,course2;
    private Teacher teacher1;
    private Student student1,student2;
    private Set hashSet = new HashSet();

    @BeforeEach
     void setup(){

        student1 = Student.builder().studentId(4).studentName("student4").passport(null).build();
        student2 = Student.builder().studentId(5).studentName("student5").passport(null).build();
        hashSet.add(student1);
        teacher1 = Teacher.builder().teacherId(4).teacherName("teacher4").build();
        course1= Course.builder().courseId(4).courseName("course4").students(hashSet).teacher(teacher1).build();
        course2= Course.builder().courseId(5).courseName("course5").students(new HashSet<>()).build();

    }


    @Test

    void saveCourse() throws Exception {
        mockMvc.perform(post("/api/courses/course")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(objectMapper.writeValueAsString(course1)))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void deleteCourseById() throws Exception {
        Integer courseId = 4;
        when(courseServiceImpl.getCourseById(courseId)).thenReturn(course1);
        mockMvc.perform(delete("/api/courses/course/{courseId}", courseId))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test

    void getCourseById() throws Exception {
        Integer courseId = 4;
        when(courseServiceImpl.getCourseById(courseId)).thenReturn(course1);
        String jsonOfCourse = objectMapper .writeValueAsString(course1);//writeValueAsString(course);
        DocumentContext docContext = JsonPath.parse(jsonOfCourse);

        MvcResult mvcResult =mockMvc.perform(get("/api/courses/course/{courseId}", courseId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.courseId").value((Integer)docContext.read("$.courseId")))
                .andExpect(jsonPath("$.courseName").value((String)docContext.read("$.courseName")))
                .andExpect(jsonPath( "$.students").value((JSONArray)docContext.read("$.students")))
                .andExpect(jsonPath("$.teacher").value((LinkedHashMap)docContext.read("$.teacher")))
                .andReturn();
        assertEquals( mvcResult.getResponse().getContentAsString(),jsonOfCourse);

    }

    @Test
    void getAllCourses() throws Exception {

        when(courseServiceImpl.getAllCourses()).thenReturn(Arrays.asList(course1,course2));
        String jsonOfCourses = objectMapper .writeValueAsString(Arrays.asList(course1,course2));//writeValueAsString(course);
        DocumentContext docContext = JsonPath.parse(jsonOfCourses);
        System.out.println(objectMapper.writeValueAsString(Arrays.asList(course1,course2)));
        MvcResult mvcResult =mockMvc.perform(get("/api/courses/course"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.[0].courseId").value((Integer)docContext.read("$.[0].courseId")))
                .andExpect(jsonPath("$.[0].courseName").value((String)docContext.read("$.[0].courseName")))
                .andExpect(jsonPath( "$.[0].students").value((JSONArray)docContext.read("$.[0].students")))
                .andExpect(jsonPath("$.[0].teacher").value((LinkedHashMap)docContext.read("$.[0].teacher")))
                .andExpect(jsonPath("$.[1].courseId").value((Integer)docContext.read("$.[1].courseId")))
                .andExpect(jsonPath("$.[1].courseName").value((String)docContext.read("$.[1].courseName")))
                .andReturn();
        assertEquals( mvcResult.getResponse().getContentAsString(),jsonOfCourses);

    }

    @Test
    void enrollStudent() throws Exception {
        Integer courseId = 5;
        Integer studentId =4;
        course2.enrollStudent(student2);
        when(courseServiceImpl.enrolledStudent(courseId,studentId)).thenReturn(course2);
        String jsonOfCourse = objectMapper .writeValueAsString(course2);//writeValueAsString(course);
        DocumentContext docContext = JsonPath.parse(jsonOfCourse);

        MvcResult mvcResult =mockMvc.perform(put("/api/courses/course/{courseId}/student/{studentId}", courseId,studentId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.courseId").value((Integer)docContext.read("$.courseId")))
                .andExpect(jsonPath("$.courseName").value((String)docContext.read("$.courseName")))
                .andExpect(jsonPath( "$.students").value((JSONArray)docContext.read("$.students")))
                .andExpect(jsonPath("$.teacher").value((LinkedHashMap)docContext.read("$.teacher")))
                .andReturn();
        assertEquals( mvcResult.getResponse().getContentAsString(),jsonOfCourse);

    }

    @Test
    void assignCourseToTeacher() throws Exception {
        Integer courseId = 5;
        Integer teacherId =4;
        course2.setTeacher(teacher1);
        when(courseServiceImpl.assignCourseToTeacher(courseId,teacherId)).thenReturn(course2);
        String jsonOfCourse = objectMapper .writeValueAsString(course2);//writeValueAsString(course);
        DocumentContext docContext = JsonPath.parse(jsonOfCourse);

        MvcResult mvcResult =mockMvc.perform(put("/api/courses/course/{courseId}/teacher/{teacherId}", courseId,teacherId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.courseId").value((Integer)docContext.read("$.courseId")))
                .andExpect(jsonPath("$.courseName").value((String)docContext.read("$.courseName")))
                .andExpect(jsonPath( "$.students").value((JSONArray)docContext.read("$.students")))
                .andExpect(jsonPath("$.teacher").value((LinkedHashMap)docContext.read("$.teacher")))
                .andReturn();
        assertEquals( mvcResult.getResponse().getContentAsString(),jsonOfCourse);

    }
}