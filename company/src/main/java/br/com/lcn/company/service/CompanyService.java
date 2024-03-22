package br.com.lcn.company.service;

import br.com.lcn.company.clients.EmployeeClient;
import br.com.lcn.company.dto.CompanyEmpolyeeDTO;
import br.com.lcn.company.dto.EmployeeDTO;
import br.com.lcn.company.model.Company;
import br.com.lcn.company.respository.CompanyRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeClient employeeClient;

    public Company findById(Integer id) {
        return companyRepository.findById(id).orElse(new Company());
    }

    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }

    @CircuitBreaker(name = "employee-service", fallbackMethod =  "findAllCompanyWithEmployeeAlternative")
    public List<CompanyEmpolyeeDTO> findAllCompanyWithEmployee(HttpHeaders headers) {
        List<Company> companies = this.companyRepository.findAll();

        List<CompanyEmpolyeeDTO> companyEmpolyeeDTOList = new ArrayList<>();

        companies.forEach( c -> {
            List<EmployeeDTO> employeeDTOList =
                    employeeClient.findAllEmployeeCompany(headers, c.getId());

            companyEmpolyeeDTOList.add(
                    CompanyEmpolyeeDTO.builder()
                            .name(c.getName())
                            .cnpj(c.getCnpj())
                            .employees(employeeDTOList)
                            .build()
            );
        });

        return companyEmpolyeeDTOList;
    }

    public List<CompanyEmpolyeeDTO> findAllCompanyWithEmployeeAlternative(HttpHeaders headers, Throwable throwable) {
        List<Company> companies = this.companyRepository.findAll();

        List<CompanyEmpolyeeDTO> companyEmpolyeeDTOList = new ArrayList<>();

        companies.forEach( c -> {
            List<EmployeeDTO> employeeDTOList = new ArrayList<>();
            employeeDTOList.add(EmployeeDTO.builder()
                            .name("NOT_FOUND")
                            .sector("NOT_FOUND")
                    .build());

            companyEmpolyeeDTOList.add(
                    CompanyEmpolyeeDTO.builder()
                            .name(c.getName())
                            .cnpj(c.getCnpj())
                            .employees(employeeDTOList)
                            .build()
            );
        });

        return companyEmpolyeeDTOList;
    }
}
