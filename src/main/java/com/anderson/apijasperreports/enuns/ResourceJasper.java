package com.anderson.apijasperreports.enuns;

public enum ResourceJasper {
    JASPER_DIRETORIO("jasper/"),
    JASPER_PREFIXO("relatorio-"),
    JASPER_SUFIXO(".jasper");

    private String value;

    ResourceJasper(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}
