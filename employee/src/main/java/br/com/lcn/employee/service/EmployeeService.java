package br.com.lcn.employee.service;

import br.com.lcn.employee.model.Employee;
import br.com.lcn.employee.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(new Employee());
    }

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<Employee> findByCompanyId(Integer id) {
        return employeeRepository.findByCompanyId(id);
    }
}
