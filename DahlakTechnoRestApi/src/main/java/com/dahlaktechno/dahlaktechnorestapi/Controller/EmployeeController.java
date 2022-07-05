package com.dahlaktechno.dahlaktechnorestapi.Controller;

import com.dahlaktechno.dahlaktechnorestapi.Model.Employee;
import com.dahlaktechno.dahlaktechnorestapi.Service.ServiceImp.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp employeeServiceImp;
    @PostMapping(value = "/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee savedEmployee =employeeServiceImp.createEmployee(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }
    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id){
       Employee employee = employeeServiceImp.getEmployee(id);
       return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }
    @PutMapping(value = "/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee existedEmployee = employeeServiceImp.updateEmployee(employee);
        return new ResponseEntity<>(existedEmployee,HttpStatus.OK);
    }
    @DeleteMapping("employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id){
        Employee employee = employeeServiceImp.deleteEmployee(id);
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }
}
