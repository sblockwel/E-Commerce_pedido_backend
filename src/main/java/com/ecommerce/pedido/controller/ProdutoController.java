package com.ecommerce.pedido.controller;

import com.ecommerce.pedido.BaseApp;
import com.ecommerce.pedido.entity.Produto;
import com.ecommerce.pedido.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/produto")
public class ProdutoController extends BaseApp {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity save(@RequestBody Produto produto){
        if (isNullOrEmpty(produto.getNome())){
            return ResponseEntity.badRequest().body("O nome não pode ser vazio!!");
        }
        if (isNullOrEmpty(produto.getPreco())){
            return ResponseEntity.badRequest().body("O preço não pode ser vazio!!");
        }
        Produto pr = produtoRepository.save(produto);
        return ResponseEntity.ok(pr);
    }

    @GetMapping
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") Long id) {
        Optional<Produto> p = produtoRepository.findById(id);

        if (p.isPresent()) {
            return ResponseEntity.ok(p.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id,
                                         @RequestBody Produto produto) {
        produtoRepository.save(produto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> delete(@PathVariable("id") Long id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
