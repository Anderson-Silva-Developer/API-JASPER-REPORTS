package com.anderson.apijasperreports.exception.handle;

import com.anderson.apijasperreports.exception.BadRequestJasper;
import com.anderson.apijasperreports.exception.DetalhesErro;
import com.anderson.apijasperreports.exception.ErroPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.io.FileNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandle {
    @ExceptionHandler(ErroPathResource.class)
    public ResponseEntity<DetalhesErro> InternaalException(ErroPathResource ex) {

        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("Erro na localização do arquivo de relatório");
        erro.setStatus(404L);
        erro.setMenssagemDesenvolvedor(ex.getMessage());
        erro.setTimestap(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }
    @ExceptionHandler(BadRequestJasper.class)
    public ResponseEntity<DetalhesErro> InternaalException(BadRequestJasper ex) {
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("Bad Request");
        erro.setStatus(400L);
        erro.setMenssagemDesenvolvedor(ex.getMessage());
        erro.setTimestap(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

    }

}
