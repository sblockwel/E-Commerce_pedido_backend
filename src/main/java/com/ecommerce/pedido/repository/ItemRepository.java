package com.ecommerce.pedido.repository;

import com.ecommerce.pedido.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
