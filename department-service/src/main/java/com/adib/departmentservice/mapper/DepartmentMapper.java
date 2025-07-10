package com.adib.departmentservice.mapper;

import com.adib.departmentservice.dto.DepartmentDto;
import com.adib.departmentservice.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto)
    {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }

    public static DepartmentDto mapToDepartmentDto(Department department)
    {
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
