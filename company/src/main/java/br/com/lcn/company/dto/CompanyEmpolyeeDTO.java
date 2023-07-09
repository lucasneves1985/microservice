package br.com.lcn.company.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyEmpolyeeDTO {

    private String name;
    private String cnpj;
    private List<EmployeeDTO> employees;


}
