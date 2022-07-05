package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Repository;

import com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport,Integer> {
}
