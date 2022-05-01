package com.anderson.apijasperreports.controller;

import com.anderson.apijasperreports.service.JasperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@RestController
@RequestMapping("/reports")
public class Reports {

    @Autowired
    private JasperService jasperService;

    @GetMapping("/relatorio/pdf/jr1")
    public ResponseEntity<byte[]> exibirRelatorio(@RequestParam( name = "code",required = false) String code) throws IOException {
        byte[] bytes = this.jasperService.exportarPDF(code);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-disposition", "inline; filename=relatorio.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(bytes);
    }

}
