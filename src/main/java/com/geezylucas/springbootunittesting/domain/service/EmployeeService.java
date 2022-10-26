package com.geezylucas.springbootunittesting.domain.service;

import com.geezylucas.springbootunittesting.domain.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> findAll();

    void deleteById(Integer id);

    void deleteAll();
}
