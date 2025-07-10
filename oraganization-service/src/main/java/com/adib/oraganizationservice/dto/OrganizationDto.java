package com.adib.oraganizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        name = "OrganizationDto Model Information"
)

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private Long id;

    @Schema(name = "Organization Name")
    private String organizationName;

    @Schema(name = "Organization Description")
    private String organizationDescription;

    @Schema(name = "Organization Code")
    private String organizationCode;

    @Schema(name = "Created Date")
    private LocalDateTime createdDate;

}
