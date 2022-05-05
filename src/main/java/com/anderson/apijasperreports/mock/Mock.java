package com.anderson.apijasperreports.mock;

import com.anderson.apijasperreports.entity.Vendas;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class Mock {

    public JRBeanCollectionDataSource mockVendas() throws ParseException {
        Date data = new Date();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
        Arrays.asList(
                new Vendas(1L,new BigDecimal("10.0"),"cliente 1",data),
                new Vendas(2L,new BigDecimal("20.0"),"cliente 2",data),
                new Vendas(3L,new BigDecimal("30.0"),"cliente 3",data),
                new Vendas(4L,new BigDecimal("40.0"),"cliente 4",data),
                new Vendas(5L,new BigDecimal("22.0"),"cliente 5",data),
                new Vendas(6L,new BigDecimal("21.0"),"cliente 6",data),
                new Vendas(7L,new BigDecimal("25.0"),"cliente 7",data),
                new Vendas(8L,new BigDecimal("28.0"),"cliente 8",data),
                new Vendas(9L,new BigDecimal("60.0"),"cliente 9",data),
                new Vendas(10L,new BigDecimal("10.0"),"cliente 10",data)

        ));

        return beanCollectionDataSource;

    }
}
