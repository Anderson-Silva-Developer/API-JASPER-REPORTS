package com.anderson.apijasperreports.service;

import com.anderson.apijasperreports.enuns.ResourceJasper;
import com.anderson.apijasperreports.exception.BadRequestJasper;
import com.anderson.apijasperreports.exception.ErroPathResource;
import com.anderson.apijasperreports.mock.Mock;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class JasperService {


    @Autowired
    private Connection connection;
    private Map<String, Object> params = new HashMap<>();


    private void addParams(String key, Object value) {
        this.params.put(key, value);
    }

    public byte[] modelo01ExportarPDF(String codigo_relatorio, Integer CODICO_CLIENTE, String NOME_CLIENTE) {
        if (Objects.isNull(codigo_relatorio)) {
            throw new BadRequestJasper("O parâmetro codigo_relatorio não pode ser nulo");
        }
        addParams("CODIGO_CLIENTE", CODICO_CLIENTE);
        addParams("NOME_CLIENTE", NOME_CLIENTE);

        byte[] bytes = null;
        try {

            File file = new ClassPathResource(
                    ResourceJasper.JASPER_DIRETORIO.getValue()
                            .concat(ResourceJasper.JASPER_PREFIXO.getValue()
                            .concat(codigo_relatorio)
                            .concat(ResourceJasper.JASPER_SUFIXO_JASPER.getValue())))
                            .getFile();

            JasperPrint print = JasperFillManager.fillReport(file.getAbsolutePath(), params, connection);
            bytes = JasperExportManager.exportReportToPdf(print);

        } catch (JRException e) {
            throw new ErroPathResource("Caminho ou arquivo não encontrado");
        } catch (IOException e) {
            throw new ErroPathResource("Caminho ou arquivo não encontrado");
        }
        return bytes;

    }

    public byte[] modeloVendasExportarPDF() {
        byte[] bytes = null;
        try {
            addParams("IMAGEM_DIRETORIO",ResourceJasper.JASPER_DIRETORIO.getValue());
            File file = new ClassPathResource(
                    ResourceJasper.JASPER_DIRETORIO.getValue()
                            .concat(ResourceJasper.JASPER_PREFIXO.getValue()
                            .concat("vendas")
                            .concat(ResourceJasper.JASPER_SUFIXO_JRXML.getValue())))
                           .getFile();

            JasperReport compileReport = JasperCompileManager
                    .compileReport(file.getAbsolutePath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, params, new Mock().mockVendas());
            bytes = JasperExportManager.exportReportToPdf(jasperPrint);


        } catch (JRException | ParseException e) {
            throw new ErroPathResource("Caminho ou arquivo não encontrado");
        } catch (FileNotFoundException e) {
            throw new ErroPathResource("Caminho ou arquivo não encontrado");
        } catch (IOException e) {
            throw new ErroPathResource("Caminho ou arquivo não encontrado");
        }
        return bytes;


    }


}
