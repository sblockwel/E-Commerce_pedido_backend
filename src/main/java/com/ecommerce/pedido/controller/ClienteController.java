package com.ecommerce.pedido.controller;

import com.ecommerce.pedido.entity.Cliente;
import com.ecommerce.pedido.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        Cliente c = repository.save(cliente);
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public List<Cliente> findAll() {
        return repository.findAll();
    }
}
