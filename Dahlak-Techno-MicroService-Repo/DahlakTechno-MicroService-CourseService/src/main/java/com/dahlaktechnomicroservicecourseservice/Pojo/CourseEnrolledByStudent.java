package com.dahlaktechnomicroservicecourseservice.Pojo;

import com.dahlaktechnomicroservicecourseservice.Model.Course;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseEnrolledByStudent {
    private Course course;
    private Student student;
}
