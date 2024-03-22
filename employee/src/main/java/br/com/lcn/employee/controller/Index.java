package br.com.lcn.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
public class Index {

    @GetMapping("/teste")
    public String index() {
        return ("OK");
    }

}
