package com.geezylucas.springbootunittesting.domain.service.impl;

import com.geezylucas.springbootunittesting.application.controller.dto.EmployeeDTO;
import com.geezylucas.springbootunittesting.domain.exception.EmployeeNotFoundException;
import com.geezylucas.springbootunittesting.domain.model.Employee;
import com.geezylucas.springbootunittesting.domain.service.EmployeeService;
import com.geezylucas.springbootunittesting.infrastructure.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO create(EmployeeDTO employee) {
        log.info("Saving employee... {}", employee);
        var newEmployee = modelMapper.map(employee, Employee.class);
        return modelMapper.map(employeeRepository.save(newEmployee), EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employee, Integer id) {
        log.info("Updating employee... {}", employee);
        return modelMapper.map(employeeRepository.findById(id)
                        .map(e -> {
                            e.setFirstName(employee.getFirstName());
                            e.setLastName(employee.getLastName());
                            return employeeRepository.save(e);
                        })
                        .orElseThrow(EmployeeNotFoundException::new),
                EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting employee with id...{}", id);
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        log.info("Deleting all employees...");
        employeeRepository.deleteAll();
    }
}
