package com.ecommerce.pedido.repository;

import com.ecommerce.pedido.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
