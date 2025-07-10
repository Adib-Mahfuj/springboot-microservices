package com.adib.oraganizationservice.controller;

import com.adib.oraganizationservice.dto.OrganizationDto;
import com.adib.oraganizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - Organization Controller",
        description = "Organization Controller exposes REST APIs for Organization Service"
)

@RestController
@AllArgsConstructor
@RequestMapping("/api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    //Build Save Rest API
    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to save Organization object in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto)
    {
        OrganizationDto savedOrganization = organizationService.createOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }



    //Build Get Rest API
    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization REST API is used to fetch a Organization object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable ("code") String orgCode)
    {
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(orgCode);
        return ResponseEntity.ok(organizationDto);
    }

}
