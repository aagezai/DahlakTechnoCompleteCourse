package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Controller;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Course;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Passport;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Student;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {
    @MockBean
    private StudentServiceImpl studentServiceImpl;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private Student student1,student2;
    private Course course1,course2;
    private Passport passport1;
    private Set<Course> courses;


    @BeforeEach
    void setUp() {
        courses = new HashSet<>();
        course1 = Course.builder().courseId(4).courseName("course4").build();
        course2 = Course.builder().courseId(5).courseName("course5").build();
        courses.add(course1);courses.add(course2);
        passport1 = Passport.builder().passportId(4).passportName("passport4").build();
        student1 = Student.builder().studentId(4).studentName("student4").build();
        student2 = Student.builder().studentId(5).studentName("student5")
                .passport(passport1).courses(courses).build();




    }

    @Test
    void saveStudent() throws Exception {
        when(studentServiceImpl.saveStudent(student1)).thenReturn(student1);
        mockMvc.perform(post("/api/students/student").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student1)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteStudentById() throws Exception {
        Integer studentId = 4;
        when(studentServiceImpl.deleteStudentById(studentId)).thenReturn(student1);
        mockMvc.perform(delete("/api/students/student/{studentId}", studentId))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void getStudentById() throws Exception {
        Integer studentId = 5;
        String jsonStudent2AsString =objectMapper.writeValueAsString(student2);
        System.out.println(jsonStudent2AsString);
        DocumentContext context = JsonPath.parse(jsonStudent2AsString);
        when(studentServiceImpl.getStudentById(studentId)).thenReturn(student2);
        MvcResult mvcResult  = mockMvc.perform(get("/api/students/student/{studentId}",studentId))
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentId").value((Integer)context.read("$.studentId")))
                .andExpect(jsonPath("$.studentName").value((String)context.read("$.studentName")))
                .andExpect(jsonPath("$.passport").value((LinkedHashMap)context.read("$.passport")))

                .andDo(print())
                .andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(),objectMapper.writeValueAsString(student2));


    }

    @Test
    void getAllStudent() throws Exception {
        List<Student> listStudents = Arrays.asList(student1,student2);
        String jsonStudentsAsString =objectMapper.writeValueAsString(listStudents);
        System.out.println(jsonStudentsAsString );
        DocumentContext context = JsonPath.parse(jsonStudentsAsString );

        when(studentServiceImpl.getAllStudents()).thenReturn(listStudents);

        MvcResult mvcResult  = mockMvc.perform(get("/api/students/student"))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].studentId").value((Integer)context.read("$.[0].studentId")))
                .andExpect(jsonPath("$.[0].studentName").value((String)context.read("$.[0].studentName")))
                .andExpect(jsonPath("$.[0].passport").value((LinkedHashMap)context.read("$.[0].passport")))
                .andExpect(jsonPath("$.[1].studentId").value((Integer)context.read("$.[1].studentId")))
                .andExpect(jsonPath("$.[1].studentName").value((String)context.read("$.[1].studentName")))
                .andExpect(jsonPath("$.[1].passport").value((LinkedHashMap)context.read("$.[1].passport")))
                .andDo(print())
                .andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(),objectMapper.writeValueAsString(listStudents));

    }

    @Test
    void setPassportToStudent() throws Exception {
        Integer studentId = 5;
        Integer passportId =4;
        student1.setPassport(passport1);
        String jsonStudent2AsString =objectMapper.writeValueAsString(student1);
        System.out.println(jsonStudent2AsString);
        DocumentContext context = JsonPath.parse(jsonStudent2AsString);
        when(studentServiceImpl.setPassportToStudent(studentId,passportId)).thenReturn(student1);

        MvcResult mvcResult  = mockMvc.perform(put("/api/students/student/{studentId}/passport/{passportId}",studentId,passportId))
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentId").value((Integer)context.read("$.studentId")))
                .andExpect(jsonPath("$.studentName").value((String)context.read("$.studentName")))
                .andExpect(jsonPath("$.passport").value((LinkedHashMap)context.read("$.passport")))
                .andDo(print())
                .andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(),objectMapper.writeValueAsString(student1));


    }
}