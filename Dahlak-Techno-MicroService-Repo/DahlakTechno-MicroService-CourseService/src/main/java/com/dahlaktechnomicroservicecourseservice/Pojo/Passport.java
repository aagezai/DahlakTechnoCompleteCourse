package com.dahlaktechnomicroservicecourseservice.Pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Passport {
    private Integer passportId;
    private String passportName;
    private Integer studentId;

}