package com.dahlakTechnoMicroserviceStudentService.Controller;


import com.dahlakTechnoMicroserviceStudentService.Model.Passport;
import com.dahlakTechnoMicroserviceStudentService.Service.ServiceImpl.PassportServiceImpl;
import com.dahlakTechnoMicroserviceStudentService.Service.ServiceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void deletePassportById(@PathVariable Integer passportId){
         passportServiceImpl.deletePassportById(passportId);
    }
    @GetMapping("/passport/{passportId}")
    public Passport getPassportById(@PathVariable Integer passportId){
        return passportServiceImpl.getPassportById(passportId);
    }
    @GetMapping("/passport")
    public List<Passport> getAllPassport(){
        return passportServiceImpl.getAllPassports();
    }


}
