package br.com.lcn.company.controller;

import br.com.lcn.company.dto.CompanyEmpolyeeDTO;
import br.com.lcn.company.model.Company;
import br.com.lcn.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> findAllCompany() {
        return ResponseEntity.ok(companyService.findAllCompany());
    }

    @GetMapping("/employee")
    public ResponseEntity<List<CompanyEmpolyeeDTO>> findAllCompanyWithEmployee(
            @RequestHeader HttpHeaders headers
            ) {
        System.out.println(headers.get("Authorization"));
        return ResponseEntity.ok(this.companyService.findAllCompanyWithEmployee(headers));
    }
}
