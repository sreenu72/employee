package com.myproject.employee.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("employee")
public class Employee {
    @Id
    private Long id;
    private String name;
    private String department;
    private String position;
    private Double salary;
}
