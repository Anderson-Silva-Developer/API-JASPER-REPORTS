package com.anderson.apijasperreports.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Vendas {
    private Long id;
    private BigDecimal preco;
    private String cliente;
    private Date dataVenda;

    public Vendas(Long id, BigDecimal preco, String cliente, Date dataVenda) {
        this.id = id;
        this.preco = preco;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}
