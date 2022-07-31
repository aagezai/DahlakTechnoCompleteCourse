package com.dahlaktechnomicroservicecourseservice.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class Course {
    @Id
    private Integer courseId;
    private String courseName;
    @ElementCollection
    private Set<Integer> studentsId = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
    private Teacher teacher;


    public boolean enrollStudent(Integer studentId) {
        log.info("insideOf enrollStudent");
        return studentsId.add(studentId);
    }
}
