package com.adib.departmentservice.service.serviceImpl;

import com.adib.departmentservice.dto.DepartmentDto;
import com.adib.departmentservice.entity.Department;
import com.adib.departmentservice.mapper.DepartmentMapper;
import com.adib.departmentservice.repository.DepartmentRepository;
import com.adib.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode)
                .orElseThrow(()-> new RuntimeException("Department not found with code : "+departmentCode));
        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
