package com.dahlaktechnomicroservicecourseservice.Repository;


import com.dahlaktechnomicroservicecourseservice.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

}
