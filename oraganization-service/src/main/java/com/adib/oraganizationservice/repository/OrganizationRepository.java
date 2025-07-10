package com.adib.oraganizationservice.repository;

import com.adib.oraganizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findByOrganizationCode(String organizationCode);
}
