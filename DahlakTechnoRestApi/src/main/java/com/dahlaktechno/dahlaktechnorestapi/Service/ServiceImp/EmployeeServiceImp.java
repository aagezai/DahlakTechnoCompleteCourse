package com.dahlaktechno.dahlaktechnorestapi.Service.ServiceImp;

import com.dahlaktechno.dahlaktechnorestapi.Exception.EmployeeFileNotFoundException;
import com.dahlaktechno.dahlaktechnorestapi.Model.Employee;
import com.dahlaktechno.dahlaktechnorestapi.Repository.EmployeeRepository;
import com.dahlaktechno.dahlaktechnorestapi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImp(){

    }
    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseThrow(() -> new EmployeeFileNotFoundException("EmployeeNOtFound","id", id)) ;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existsEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new EmployeeFileNotFoundException("Employe","id",employee.getId()));

        existsEmployee.setFirstName(employee.getFirstName());
       existsEmployee.setLastName(employee.getLastName());
       existsEmployee.setId(employee.getId());
       existsEmployee.setSsn(employee.getSsn());
       employeeRepository.save(existsEmployee);

        return existsEmployee;
    }

    @Override
    public Employee deleteEmployee(Integer id) {
        Employee existsEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeFileNotFoundException("Employe","id",id));

        employeeRepository.deleteById(id);
        return existsEmployee;
    }
}
