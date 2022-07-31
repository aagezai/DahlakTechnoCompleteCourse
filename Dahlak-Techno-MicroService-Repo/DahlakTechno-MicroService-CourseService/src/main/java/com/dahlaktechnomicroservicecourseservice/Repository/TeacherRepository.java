package com.dahlaktechnomicroservicecourseservice.Repository;


import com.dahlaktechnomicroservicecourseservice.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
