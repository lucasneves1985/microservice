package br.com.lcn.company.clients;

import br.com.lcn.company.dto.EmployeeDTO;
import feign.HeaderMap;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

@FeignClient(name = "employee", path = "/emp/employee")
public interface EmployeeClient {
    @GetMapping("/company/{id}")
    List<EmployeeDTO> findAllEmployeeCompany(@RequestHeader HttpHeaders headers, @PathVariable("id") Integer companyId);

}
