package com.anderson.apijasperreports.enuns;

public enum URLJasper {
    JASPER_DIRETORIO("jasper/"),
    JASPER_PREFIXO("relatorio-"),
    JASPER_SUFIXO_JASPER(".jasper"),
    JASPER_SUFIXO_JRXML(".jrxml");

    private String value;

    URLJasper(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}
