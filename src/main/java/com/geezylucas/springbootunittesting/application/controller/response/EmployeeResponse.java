package com.geezylucas.springbootunittesting.application.controller.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeResponse {

    private Integer id;
    private String firstName;
    private String lastName;
}
