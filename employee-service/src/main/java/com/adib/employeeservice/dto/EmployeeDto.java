package com.adib.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        name = "EmployeeDto Model Information"
)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;

    @Schema(name = "First Name")
    private String firstName;

    @Schema(name = "Last Name")
    private String lastName;

    @Schema(name = "Email")
    private String email;

    @Schema(name = "Department Code")
    private String departmentCode;

    @Schema(name = "Organization Code")
    private String organizationCode;
}
