package com.dahlaktechnomicroservicecourseservice.Controller;
import com.dahlaktechnomicroservicecourseservice.Service.ServiceImpl.TeacherServiceImpl;
import com.dahlaktechnomicroservicecourseservice.Model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers/")
@Slf4j
public class TeacherController {
    private TeacherServiceImpl teacherServiceImpl;
    @Autowired
    public TeacherController(TeacherServiceImpl teacherServiceImpl) {
        this.teacherServiceImpl = teacherServiceImpl;
    }
    @PostMapping("/teacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        log.info("inside of saveTeacher");
        return teacherServiceImpl.saveTeacher(teacher);
    }
    @DeleteMapping("teacher/{teacherId}")
    public Teacher deleteTeacherById(@PathVariable Integer teacherId){
        log.info("inSideOf deleteTeacherById ");
        return teacherServiceImpl.deleteTeacherById(teacherId);
    }
    @GetMapping("teacher/{teacherId}")
    public Teacher getTeacherById(@PathVariable Integer teacherId){
        log.info("inSideOf getTeacherById");
        return teacherServiceImpl.getTeacherById(teacherId);
    }
    @GetMapping("/teacher")
    public List<Teacher> getAllTeachers(){
        log.info("inSideOf getAllTeachers");
        return teacherServiceImpl.getAllTeacher();
    }
}
