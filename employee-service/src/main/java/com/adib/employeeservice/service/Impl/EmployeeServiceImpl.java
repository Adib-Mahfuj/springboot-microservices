package com.adib.employeeservice.service.Impl;
import com.adib.employeeservice.dto.ApiResponseDto;
import com.adib.employeeservice.dto.DepartmentDto;
import com.adib.employeeservice.dto.EmployeeDto;
import com.adib.employeeservice.dto.OrganizationDto;
import com.adib.employeeservice.entity.Employee;
import com.adib.employeeservice.mapper.EmployeeMapper;
import com.adib.employeeservice.repository.EmployeeRepository;
import com.adib.employeeservice.service.APIClient;
import com.adib.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
    private WebClient webClient;
//    private APIClient apiClient;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDeafultDepartment")
    @Retry(name="${spring.application.name}", fallbackMethod = "getDeafultDepartment")
    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        LOGGER.info("Inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found by given id : " + employeeId));

//        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.
//                getForEntity("http://localhost:8080/api/departments/"
//                        +employee.getDepartmentCode(),DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);

        return apiResponseDto;
    }

    public ApiResponseDto getDeafultDepartment(Long employeeId, Exception exception) {
        LOGGER.info("Inside getDeafultDepartment() method");
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found by given id : " + employeeId));

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode("RD003");
        departmentDto.setDepartmentName("R&D");
        departmentDto.setDepartmentDescription("Research and Development");

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
