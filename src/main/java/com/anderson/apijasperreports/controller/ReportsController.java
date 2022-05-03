package com.anderson.apijasperreports.controller;

import com.anderson.apijasperreports.service.JasperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private JasperService jasperService;
    @GetMapping("/relatorio/pdf/jr1")
    public ResponseEntity<byte[]> exibirRelatorio(
            @RequestParam( name = "codigo_relatorio",required = false) String codigo_relatorio,
            @RequestParam( name = "codigo_cliente",required = false) Integer CODICO_CLIENTE,
            @RequestParam( name = "nome_cliente",required = false) String NOME_CLIENTE) throws IOException {


        byte[] bytes = this.jasperService.modelo01ExportarPDF(codigo_relatorio,CODICO_CLIENTE,NOME_CLIENTE);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-disposition", "inline; filename=relatorio-"+codigo_relatorio+".pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(bytes);
    }

    @GetMapping("/relatorio/pdf/jr2")
    public ResponseEntity<byte[]> exibirRelatorio() throws IOException {

        byte[] bytes = this.jasperService.modeloVendasExportarPDF();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-disposition", "inline; filename=relatorio-vendas.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(bytes);
    }

}
