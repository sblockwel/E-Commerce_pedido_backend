package com.ecommerce.pedido.repository;

import com.ecommerce.pedido.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContainingOrderByIdDesc(String nome);

    @Query("select c from Cliente c where nome = :nome order by c.id desc")
    List<Cliente> findByCliente(String nome);

}
