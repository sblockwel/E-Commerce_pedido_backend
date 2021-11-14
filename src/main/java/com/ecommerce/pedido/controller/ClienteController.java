package com.ecommerce.pedido.controller;

import com.ecommerce.pedido.BaseApp;
import com.ecommerce.pedido.entity.Cliente;
import com.ecommerce.pedido.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/cliente")
public class ClienteController extends BaseApp {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> get(@RequestParam(required = false, defaultValue = "nome") String orderField,
                             @RequestParam(required = false) String filter){
        if (filter != null) {
            return clienteRepository.findByNomeContainingOrderByIdDesc(filter);
        }
        Sort order = Sort.by(Sort.Direction.ASC, orderField);
        return clienteRepository.findAll(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") Long id) {
        Optional<Cliente> m = clienteRepository.findById(id);

        if (m.isPresent()) {
            return ResponseEntity.ok(m.get());
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping
    public ResponseEntity save(@RequestBody Cliente cliente) {
        if (isNullOrEmpty(cliente.getNome())){
            return ResponseEntity.badRequest().body("Nome não pode ser vazio!!");
        }
        Cliente nova = clienteRepository.save(cliente);
        return ResponseEntity.ok(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id,
                                        @RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
