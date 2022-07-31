package com.dahlaktechnomicroservicecourseservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    private Integer teacherId;
    private String teacherName;
    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<Course> courses = new HashSet<>();



}
