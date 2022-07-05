package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Teacher;

public interface TeacherService {
    public Teacher  saveTeacher(Teacher teacher);
    public Teacher  deleteTeacherById(Integer teacherId);
    public  Teacher getTeacherById(Integer teacherId);
}
