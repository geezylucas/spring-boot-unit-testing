package com.geezylucas.springbootunittesting.application.controller;

import com.geezylucas.springbootunittesting.application.controller.dto.EmployeeDTO;
import com.geezylucas.springbootunittesting.domain.exception.EmployeeNotFoundException;
import com.geezylucas.springbootunittesting.domain.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employee));
    }

    @PutMapping("/{id}")
    ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employee, @PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.update(employee, id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    ResponseEntity<Void> deleteEmployees() {
        employeeService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String handleNotFoundEmployeeUpdate() {
        return "Could not find employee";
    }

}
