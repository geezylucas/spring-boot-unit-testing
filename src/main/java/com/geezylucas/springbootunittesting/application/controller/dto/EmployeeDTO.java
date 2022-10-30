package com.geezylucas.springbootunittesting.application.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDTO {
    private Integer id;
    private String firstName;
    private String lastName;
}
