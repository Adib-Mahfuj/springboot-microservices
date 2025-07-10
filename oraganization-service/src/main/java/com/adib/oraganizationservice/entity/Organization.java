package com.adib.oraganizationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_seq")
    @SequenceGenerator(name = "organization_seq", sequenceName = "ORGANIZATION_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "Organization_Name", nullable = false,unique = true)
    private String organizationName;
    @Column(name = "Organization_Description")
    private String organizationDescription;
    @Column(name = "Organization_Code", nullable = false, unique = true)
    private String organizationCode;
    @Column(name = "Created_Date")
    @CreationTimestamp
    private LocalDateTime createdDate;
}
