package com.dahlaktechno.dahlaktechnorestapi.Service;

import com.dahlaktechno.dahlaktechnorestapi.Model.Employee;

public interface EmployeeService {
    // crud --> create read update delete
    //          post   get   update delete
    public Employee createEmployee(Employee employee);
    public Employee getEmployee(Integer id);
    public Employee updateEmployee(Employee employee);
    public Employee deleteEmployee(Integer id);

}
