package com.ecommerce.pedido.controller;

import com.ecommerce.pedido.entity.Pedido;
import com.ecommerce.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        Pedido c = repository.save(pedido);
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public List<Pedido> findAll() {
        return repository.findAll();
    }

}
