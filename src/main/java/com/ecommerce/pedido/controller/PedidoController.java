package com.ecommerce.pedido.controller;

import com.ecommerce.pedido.BaseApp;
import com.ecommerce.pedido.data_models.ItemModel;
import com.ecommerce.pedido.data_models.PedidoModel;
import com.ecommerce.pedido.data_models.PedidoResponse;
import com.ecommerce.pedido.entity.Pedido;
import com.ecommerce.pedido.repository.PedidoRepository;
import com.ecommerce.pedido.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/pedido")
public class PedidoController extends BaseApp {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private IPedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponse> save(@RequestBody PedidoModel model) {
        try {
            PedidoResponse p = pedidoService.addPedido(model);
            return ResponseEntity.ok(p);
        } catch (ValidationException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/item")
    public ResponseEntity addItem(@RequestBody ItemModel itemModel){
        try {
            pedidoService.addItem(itemModel);
            return ResponseEntity.ok().build();
        } catch (ValidationException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable("id") Long id) {
        Optional<Pedido> p = pedidoRepository.findById(id);

        if (p.isPresent()) {
            return ResponseEntity.ok(p.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable("id") Long id,
                                          @RequestBody Pedido pedido) {
        pedidoRepository.save(pedido);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> delete(@PathVariable("id") Long id) {
        pedidoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
