package com.anderson.apijasperreports.service;

import com.anderson.apijasperreports.enuns.ResourceJasper;
import com.anderson.apijasperreports.exception.BadRequestJasper;
import com.anderson.apijasperreports.exception.ErroPathResource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class JasperService {
    @Autowired
    private Connection connection;
    private Map<String, Object> params = new HashMap<>();

    public void addParams(String key, Object value) {
        this.params.put(key, value);
    }

    public byte[] modelo01ExportarPDF(String codigo_relatorio,Integer CODICO_CLIENTE,String NOME_CLIENTE) {
        if (Objects.isNull(codigo_relatorio)){
            throw new BadRequestJasper("O parâmetro codigo_relatorio não pode ser nulo");
        }
        addParams("CODIGO_CLIENTE",CODICO_CLIENTE);
        addParams("NOME_CLIENTE",NOME_CLIENTE);

        byte[] bytes = null;
        try {

            File file=new ClassPathResource(
                    ResourceJasper.JASPER_DIRETORIO.getValue()
                    .concat(ResourceJasper.JASPER_PREFIXO.getValue()
                    .concat(codigo_relatorio)
                    .concat(ResourceJasper.JASPER_SUFIXO.getValue())))
                    .getFile();

            JasperPrint print = JasperFillManager.fillReport(file.getAbsolutePath(), params, connection);
            bytes = JasperExportManager.exportReportToPdf(print);

        } catch (JRException e) {
            throw new ErroPathResource("Caminho ou arquivo não encontrado");
        }
        catch (IOException e) {
            throw new ErroPathResource("Caminho ou arquivo não encontrado");
        }
        return bytes;

    }

}
