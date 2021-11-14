package com.ecommerce.pedido;

import java.util.Date;

public class BaseApp {

    protected boolean isNullOrEmpty(String texto){
        return texto == null || texto.isBlank();
    }
    protected boolean isNullOrEmpty(Float valor){
        return valor == null || valor.isNaN();
    }
    protected boolean isNullOrEmpty(Double valor){
        return valor == null || valor.isNaN();
    }
    protected boolean isNullOrEmpty(Integer valor){
        return valor == null || valor <= 0;
    }
    protected boolean isNullOrEmpty(Long valor){
        try {
            return valor == null ;
        } catch (Exception e) {
            return true;
        }
    }
    protected boolean isNullOrEmpty(Date data){
        return data == null;
    }

}
