package com.ecommerce.pedido.controller;

import com.ecommerce.pedido.entity.Cliente;
import com.ecommerce.pedido.entity.Produto;
import com.ecommerce.pedido.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        Produto p = repository.save(produto);
        return ResponseEntity.ok(p);
    }

    @GetMapping
    public List<Produto> findAll() {
        return repository.findAll();
    }
}
