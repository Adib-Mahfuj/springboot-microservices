package com.adib.employeeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "emp_seq")
    @SequenceGenerator(name = "emp_seq", sequenceName = "EMPLOYEE_SEQ",allocationSize = 1)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email_id",nullable = false,unique = true)
    private String email;
    @Column(name = "dept_code")
    private String departmentCode;
    @Column(name = "Organization_Code")
    private String organizationCode;
}
