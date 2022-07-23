package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.ServiceImpl;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Exception.ResourceNotFoundException;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Passport;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Repository.PassportRepository;
import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {
    private PassportRepository passportRepository;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public Passport savePassport(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Passport deletePassportById(Integer passportId) {
        Passport passport =getPassportById(passportId);
        passportRepository.deleteById(passportId);
        return passport;
    }

    @Override
    public Passport getPassportById(Integer passportId) {
       return passportRepository.findById(passportId).
                orElseThrow(() ->new ResourceNotFoundException("passport","passportId",passportId));
    }

    @Override
    public List<Passport> getAllPassports() {
        return passportRepository.findAll();
    }
}
