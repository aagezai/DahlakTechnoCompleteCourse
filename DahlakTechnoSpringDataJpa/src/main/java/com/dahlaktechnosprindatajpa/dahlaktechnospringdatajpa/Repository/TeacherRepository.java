package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Repository;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
