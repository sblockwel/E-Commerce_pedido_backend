package com.ecommerce.pedido.data_models;

import com.ecommerce.pedido.entity.Cliente;

public class PedidoResponse {
    private Integer numero;
    private Long id;
    private float valor_total;
    private Cliente cliente;

    public PedidoResponse() {
    }

    public PedidoResponse(Long id, Integer numero) {
        this.numero = numero;
        this.id = id;
    }

    public PedidoResponse(Long id, Integer numero, Cliente cliente) {
        this.numero = numero;
        this.id = id;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getValorTotal() {
        return valor_total;
    }

    public void setValorTotal(float valor_total) {
        this.valor_total = valor_total;
    }


    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
