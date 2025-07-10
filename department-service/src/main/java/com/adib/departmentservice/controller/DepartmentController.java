package com.adib.departmentservice.controller;

import com.adib.departmentservice.dto.DepartmentDto;
import com.adib.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - Department Controller",
        description = "Department Controller Exposes REST APIs for Department Service"
)

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {
    DepartmentService departmentService;

    //Build save REST API
    @Operation(
            summary = "Save Department REST API",
            description = "Save Department REST API is used to save department object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto)
    {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    //Build get REST API
    @Operation(
            summary = "Get Department REST API",
            description = "Get Department REST API is used to get a department object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS "
    )
    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable ("code") String departmentCode)
    {
        DepartmentDto getDepartment = departmentService.getDepartmentByCode(departmentCode);
        return ResponseEntity.ok(getDepartment);
    }
}
