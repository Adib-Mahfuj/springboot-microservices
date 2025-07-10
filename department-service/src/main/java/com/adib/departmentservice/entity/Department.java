package com.adib.departmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    @SequenceGenerator(name = "department_seq", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "dept_name",nullable = false,unique = true)
    private  String departmentName;
    @Column(name = "dept_desc")
    private String departmentDescription;
    @Column(name = "dept_code")
    private String departmentCode;

}
