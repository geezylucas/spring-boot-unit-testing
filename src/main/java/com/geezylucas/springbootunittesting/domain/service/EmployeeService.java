package com.geezylucas.springbootunittesting.domain.service;

import com.geezylucas.springbootunittesting.domain.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);

    Employee update(Employee employee, Integer id);

    List<Employee> findAll();

    void deleteById(Integer id);

    void deleteAll();
}
