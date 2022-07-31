package com.dahlaktechnomicroservicecourseservice.Service.ServiceImpl;


import com.dahlaktechnomicroservicecourseservice.Repository.TeacherRepository;
import com.dahlaktechnomicroservicecourseservice.Exception.ResourceNotFoundException;
import com.dahlaktechnomicroservicecourseservice.Model.Teacher;
import com.dahlaktechnomicroservicecourseservice.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("teacher","teacherId",teacherId));

    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher deleteTeacherById(Integer teacherId) {
        Teacher teacher = getTeacherById(teacherId);
        teacherRepository.deleteById(teacherId);
        return teacher ;
    }



}
