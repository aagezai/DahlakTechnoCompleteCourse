package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Service;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Passport;

import java.util.List;

public interface PassportService {
    public Passport savePassport(Passport passport);
    public Passport deletePassportById(Integer passportId);
    public Passport getPassportById(Integer passportId);
    List<Passport> getAllPassports();
}
