package com.adib.employeeservice.service;

import com.adib.employeeservice.dto.ApiResponseDto;
import com.adib.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long employeeId);
}
