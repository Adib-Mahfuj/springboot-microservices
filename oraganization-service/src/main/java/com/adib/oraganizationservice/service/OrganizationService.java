package com.adib.oraganizationservice.service;

import com.adib.oraganizationservice.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto createOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String orgCode);

}
