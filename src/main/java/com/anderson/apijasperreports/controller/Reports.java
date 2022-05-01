package com.anderson.apijasperreports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@RestController
@RequestMapping("/reports")
public class Reports {

    @Autowired
    private Connection connection;

    @GetMapping("/hello")
    @ResponseBody
    public String helloJasperReports(){
        return connection!=null?"JASPER-REPORTS":"Erro de conexão";
    }

}
