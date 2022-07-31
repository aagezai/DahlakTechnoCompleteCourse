package com.dahlaktechnomicroservicecourseservice.Service;


import com.dahlaktechnomicroservicecourseservice.Model.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher saveTeacher(Teacher teacher);
    public Teacher  deleteTeacherById(Integer teacherId);
    public  Teacher getTeacherById(Integer teacherId);
    public List<Teacher> getAllTeacher();
}
