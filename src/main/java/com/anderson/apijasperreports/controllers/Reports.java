package com.anderson.apijasperreports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class Reports {

    @GetMapping("/hello")
    @ResponseBody
    public String helloJasperReports(){

        return "JASPER-REPORTS";
    }

}
