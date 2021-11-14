package com.ecommerce.pedido.controller;

import com.ecommerce.pedido.BaseApp;
import com.ecommerce.pedido.data_models.ItemModel;
import com.ecommerce.pedido.entity.Item;
import com.ecommerce.pedido.repository.ItemRepository;
import com.ecommerce.pedido.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/item")
public class ItemController  extends BaseApp {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private IPedidoService pedidoService;

    @PostMapping
    public ResponseEntity save(@RequestBody ItemModel model){
        try {
            pedidoService.addItem(model);
            return ResponseEntity.ok().build();
        } catch (ValidationException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") Long id) {
        Optional<Item> i = itemRepository.findById(id);

        if (i.isPresent()) {
            return ResponseEntity.ok(i.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable("id") Long id,
                                         @RequestBody Item item) {
        itemRepository.save(item);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> delete(@PathVariable("id") Long id) {
        itemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
