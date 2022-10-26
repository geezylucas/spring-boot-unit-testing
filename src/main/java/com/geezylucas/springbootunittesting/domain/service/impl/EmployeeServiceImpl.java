package com.geezylucas.springbootunittesting.domain.service.impl;

import com.geezylucas.springbootunittesting.domain.exception.SaveEmployeeException;
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
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            return employeeRepository.save(employee);
        }

        return employeeRepository.findById(employee.getId())
                .map(e -> {
                    e.setFirstName(employee.getFirstName());
                    e.setLastName(employee.getLastName());
                    return employeeRepository.save(e);
                }).orElseThrow(SaveEmployeeException::new);
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
