package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Teacher;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Repository.TeacherRepository;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;
    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    @Override
    public Teacher getTeacherById(Integer teacherId) {
        return teacherRepository.findById(teacherId).get();
    }

    @Override
    public Teacher deleteTeacherById(Integer teacherId) {
        return null;
    }


}
