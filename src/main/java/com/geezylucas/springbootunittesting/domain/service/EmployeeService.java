package com.geezylucas.springbootunittesting.domain.service;

import com.geezylucas.springbootunittesting.application.controller.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO create(EmployeeDTO employee);

    EmployeeDTO update(EmployeeDTO employee, Integer id);

    List<EmployeeDTO> findAll();

    void deleteById(Integer id);

    void deleteAll();
}
