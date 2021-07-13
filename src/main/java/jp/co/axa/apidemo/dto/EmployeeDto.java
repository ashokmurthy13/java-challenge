package jp.co.axa.apidemo.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String name;
    private Integer salary;
    private String department;
}
