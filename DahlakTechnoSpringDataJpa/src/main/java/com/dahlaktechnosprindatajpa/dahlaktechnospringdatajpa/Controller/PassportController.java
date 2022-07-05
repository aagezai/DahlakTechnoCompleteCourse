package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Controller;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Passport;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Student;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.PassportServiceImpl;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;

@RestController
@RequestMapping("/api/passports")
public class PassportController {
    private PassportServiceImpl passportServiceImpl;

    private StudentServiceImpl studentServiceImpl;
    @Autowired
    public PassportController(PassportServiceImpl passportServiceImpl,
                              StudentServiceImpl studentServiceImpl) {
        this.passportServiceImpl = passportServiceImpl;
        this.studentServiceImpl = studentServiceImpl;
    }
    @PostMapping("/passport")
    public Passport savePassPort(@RequestBody Passport passport){
        return passportServiceImpl.savePassport(passport);
    }
    @DeleteMapping("/passport/{passportId}")
    public Passport deletePassportById(@PathVariable Integer passportId){
        return  passportServiceImpl.deletePassportById(passportId);
    }
    @GetMapping("/passport/{passportId}")
    public Passport getPassportById(@PathVariable Integer passportId){
        return passportServiceImpl.getPassportById(passportId);
    }


}
