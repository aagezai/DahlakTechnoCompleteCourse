package com.dahlaktechno.dahlaktechnorestapi.Repository;

import com.dahlaktechno.dahlaktechnorestapi.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
