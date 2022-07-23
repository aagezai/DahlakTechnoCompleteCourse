package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Controller;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Teacher;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/api/teachers/")
public class TeacherController {
    private TeacherServiceImpl teacherServiceImpl;
    @Autowired
    public TeacherController(TeacherServiceImpl teacherServiceImpl) {
        this.teacherServiceImpl = teacherServiceImpl;
    }
    @PostMapping("/teacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherServiceImpl.saveTeacher(teacher);
    }
    @DeleteMapping("teacher/{teacherId}")
    public Teacher deleteTeacherById(@PathVariable Integer teacherId){
        return teacherServiceImpl.deleteTeacherById(teacherId);
    }
    @GetMapping("teacher/{teacherId}")
    public Teacher getTeacherById(@PathVariable Integer teacherId){
        return teacherServiceImpl.getTeacherById(teacherId);
    }
    @GetMapping("/teacher")
    public List<Teacher> getAllTeachers(){
        return teacherServiceImpl.getAllTeacher();
    }
}
