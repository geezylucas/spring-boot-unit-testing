package com.geezylucas.springbootunittesting.domain.service.impl;

import com.geezylucas.springbootunittesting.domain.model.Employee;
import com.geezylucas.springbootunittesting.domain.service.EmployeeService;
import com.geezylucas.springbootunittesting.infrastructure.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee, Integer id) {
        return employeeRepository.findById(id)
                .map(e -> {
                    e.setFirstName(employee.getFirstName());
                    e.setLastName(employee.getLastName());
                    return employeeRepository.save(e);
                })
                .orElseGet(() -> {
                    employee.setId(id);
                    return employeeRepository.save(employee);
                });
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
