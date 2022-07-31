package com.dahlakTechnoMicroserviceStudentService.Repository;

import com.dahlakTechnoMicroserviceStudentService.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
