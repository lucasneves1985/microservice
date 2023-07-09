package br.com.lcn.employee.controller;

import br.com.lcn.employee.model.Employee;
import br.com.lcn.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployee() {
        return ResponseEntity.ok(employeeService.findAllEmployee());
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<List<Employee>> findAllEmployeeByCompany(
            @RequestHeader HttpHeaders headers,
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(employeeService.findByCompanyId(id));
    }
}
