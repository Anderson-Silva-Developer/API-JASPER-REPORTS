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
        DateFormat f = DateFormat.getDateInstance();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
        Arrays.asList(
                new Vendas(1L,new BigDecimal("10.0"),"cliente 1",new Date()),
                new Vendas(2L,new BigDecimal("20.0"),"cliente 2",new Date()),
                new Vendas(3L,new BigDecimal("30.0"),"cliente 3",new Date()),
                new Vendas(4L,new BigDecimal("40.0"),"cliente 4",new Date()),
                new Vendas(5L,new BigDecimal("22.0"),"cliente 5",new Date()),
                new Vendas(6L,new BigDecimal("21.0"),"cliente 6",new Date()),
                new Vendas(7L,new BigDecimal("25.0"),"cliente 7",new Date()),
                new Vendas(8L,new BigDecimal("28.0"),"cliente 8",new Date()),
                new Vendas(9L,new BigDecimal("60.0"),"cliente 9",new Date()),
                new Vendas(10L,new BigDecimal("10.0"),"cliente 10",new Date())

        ),false);

        return beanCollectionDataSource;

    }
}
