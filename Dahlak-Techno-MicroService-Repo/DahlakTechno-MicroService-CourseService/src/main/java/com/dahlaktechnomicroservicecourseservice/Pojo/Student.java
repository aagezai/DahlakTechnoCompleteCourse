package com.dahlaktechnomicroservicecourseservice.Pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private Integer studentId;
    private String studentName;
    private Passport passport;
    private Set<Integer> coursesId = new HashSet<>();


}
