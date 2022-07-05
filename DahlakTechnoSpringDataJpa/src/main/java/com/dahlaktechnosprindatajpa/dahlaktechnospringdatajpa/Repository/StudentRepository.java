package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Repository;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
