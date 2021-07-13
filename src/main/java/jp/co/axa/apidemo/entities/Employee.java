package jp.co.axa.apidemo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Getter
    @Setter
    @Id
    private Long id;

    @Getter
    @Setter
    @Column(name = "EMPLOYEE_NAME")
    private String name;

    @Getter
    @Setter
    @Column(name = "EMPLOYEE_SALARY")
    private Integer salary;

    @Getter
    @Setter
    @Column(name = "DEPARTMENT")
    private String department;
}
