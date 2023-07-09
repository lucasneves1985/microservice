package br.com.lcn.company.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private String name;
    private String sector;
    private Integer companyId;
}
