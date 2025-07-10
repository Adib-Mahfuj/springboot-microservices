package com.adib.oraganizationservice.service.impl;

import com.adib.oraganizationservice.dto.OrganizationDto;
import com.adib.oraganizationservice.entity.Organization;
import com.adib.oraganizationservice.mapper.OrganizationMapper;
import com.adib.oraganizationservice.repository.OrganizationRepository;
import com.adib.oraganizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String orgCode) {
        Organization organization = organizationRepository.findByOrganizationCode(orgCode).
                orElseThrow(() -> new RuntimeException("Organization not found with this code : "+orgCode));
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
