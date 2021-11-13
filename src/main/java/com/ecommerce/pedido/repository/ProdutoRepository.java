package com.ecommerce.pedido.repository;

import com.ecommerce.pedido.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
