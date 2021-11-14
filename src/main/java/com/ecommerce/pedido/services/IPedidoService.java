package com.ecommerce.pedido.services;

import com.ecommerce.pedido.data_models.ItemModel;
import com.ecommerce.pedido.data_models.PedidoModel;
import com.ecommerce.pedido.data_models.PedidoResponse;
import com.ecommerce.pedido.entity.Pedido;

import javax.xml.bind.ValidationException;

public interface IPedidoService {

    void addItem(ItemModel itemModel) throws ValidationException;
    PedidoResponse addPedido(PedidoModel pedidoModel) throws ValidationException;

}
