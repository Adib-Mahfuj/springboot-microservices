package com.adib.employeeservice.controller;

import com.adib.employeeservice.dto.ApiResponseDto;
import com.adib.employeeservice.dto.EmployeeDto;
import com.adib.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee Service - Employee Controller",
        description = "Employee Controller exposes REST APIs for Employee Service"
)

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    //Build Save REST API
    @Operation(
            summary = "Save Employee REST API",
            description = "Save Employee REST API is used to save Employee object in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
       EmployeeDto savedEmployee =  employeeService.saveEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }



    //Build get REST API
    @Operation(
            summary = "Get Employee REST API",
            description = "Get Employee REST API is used to fetch a Employee object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable ("id") Long employeeId)
    {
       ApiResponseDto apiResponseDto =  employeeService.getEmployeeById(employeeId);
       return ResponseEntity.ok(apiResponseDto);
    }
}
