package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Repository;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

}
