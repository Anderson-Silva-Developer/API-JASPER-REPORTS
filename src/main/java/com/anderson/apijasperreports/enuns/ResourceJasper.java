package com.anderson.apijasperreports.enuns;

public enum ResourceJasper {
    JASPER_DIRETORIO("jasper/"),
    JASPER_PREFIXO("relatorio-"),
    JASPER_SUFIXO_JASPER(".jasper"),
    JASPER_SUFIXO_JRXML(".jrxml");

    private String value;

    ResourceJasper(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}
