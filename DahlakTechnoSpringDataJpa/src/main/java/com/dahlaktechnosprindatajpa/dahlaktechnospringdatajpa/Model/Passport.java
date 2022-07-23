package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Passport {
    @Id
    private Integer passportId;
    private String passportName;
    @JsonIgnore
    @OneToOne(mappedBy = "passport")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Student student;


}