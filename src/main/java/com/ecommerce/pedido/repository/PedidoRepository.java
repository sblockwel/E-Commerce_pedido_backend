package com.ecommerce.pedido.repository;

import com.ecommerce.pedido.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

    @Query("select coalesce(max(numero), 0)+ 1 from Pedido ")
    Integer getNumeroPedido();
    @Query("select p from Pedido p where numero = :numero ")
    Pedido getPedidoByNumero(int numero);

}
