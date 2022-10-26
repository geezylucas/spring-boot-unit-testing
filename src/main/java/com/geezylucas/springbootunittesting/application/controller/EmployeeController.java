package com.geezylucas.springbootunittesting.application.controller;

import com.geezylucas.springbootunittesting.domain.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
}
