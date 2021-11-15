package com.ecommerce.pedido.repository;

import com.ecommerce.pedido.data_models.PedidoResponse;
import com.ecommerce.pedido.entity.Item;
import com.ecommerce.pedido.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

    @Query("select coalesce(max(numero), 0)+ 1 from Pedido ")
    Integer getNumeroPedido();
    @Query("select p from Pedido p where numero = :numero ")
    Pedido getPedidoByNumero(int numero);
    @Query("select i from Item i join i.pedido p where p.id = :id ")
    List<Item> getItensPedido(Long id);
    @Query("SELECT COALESCE(SUM(COALESCE(pp.preco, 0) * COALESCE(i.quantidade, 0)), 0) FROM Item i JOIN i.pedido p JOIN i.produto pp WHERE p.numero = :numero ")
    float getSumPedido(int numero);
    @Query("select new com.ecommerce.pedido.data_models.PedidoResponse(p.id, p.numero, p.cliente) from Pedido p JOIN p.cliente c ")
    List<PedidoResponse> getPedidos();
    @Transactional
    @Modifying
    @Query("delete from Item i where i.pedido.id = :id ")
    void removeItensPedido(Long id);
    @Transactional
    @Modifying
    @Query("delete from Pedido p where p.id = :id ")
    void removePedidoByNumero(Long id);
}
