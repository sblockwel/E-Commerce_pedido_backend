package com.ecommerce.pedido.services;

import com.ecommerce.pedido.BaseApp;
import com.ecommerce.pedido.data_models.ItemModel;
import com.ecommerce.pedido.data_models.PedidoModel;
import com.ecommerce.pedido.data_models.PedidoResponse;
import com.ecommerce.pedido.entity.Cliente;
import com.ecommerce.pedido.entity.Item;
import com.ecommerce.pedido.entity.Pedido;
import com.ecommerce.pedido.entity.Produto;
import com.ecommerce.pedido.repository.ClienteRepository;
import com.ecommerce.pedido.repository.ItemRepository;
import com.ecommerce.pedido.repository.PedidoRepository;
import com.ecommerce.pedido.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
@Service
public class PedidoService extends BaseApp implements IPedidoService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void addItem(ItemModel itemModel) throws ValidationException {
        if (isNullOrEmpty(itemModel.getQuantidade())){
            throw new ValidationException("A quantidade não pode ser vazia!!");
        }
        if (isNullOrEmpty(itemModel.getProduto())){
            throw new ValidationException("O produto não pode ser vazio!!");
        }
        if (isNullOrEmpty(itemModel.getPedido())){
            throw new ValidationException("O pedido não pode ser vazio!!");
        }
        Produto produto = produtoRepository.getById(itemModel.getProduto());
        Pedido pedido = pedidoRepository.getPedidoByNumero(itemModel.getPedido());
        Item item = new Item();
        item.setProduto(produto);
        item.setPedido(pedido);

        item.setQuantidade(itemModel.getQuantidade());
        Item i = itemRepository.save(item);
    }

    @Override
    public PedidoResponse addPedido(PedidoModel pedidoModel) throws ValidationException {
        if (isNullOrEmpty(pedidoModel.getDataEmissao())){
            throw new ValidationException("A data não pode ser vazia!!");
        }
        if (isNullOrEmpty(pedidoModel.getNumero())){
            pedidoModel.setNumero(pedidoRepository.getNumeroPedido());
        }
        if (isNullOrEmpty(pedidoModel.getCliente())){
            throw new ValidationException("O nome não pode ser vazio!!");
        }
        Cliente cliente = clienteRepository.getById(pedidoModel.getCliente());
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataEmissao(pedidoModel.getDataEmissao());
        pedido.setNumero(pedidoModel.getNumero());
        PedidoResponse response = new PedidoResponse();
        response.setNumero(pedidoModel.getNumero());
        Pedido p = pedidoRepository.save(pedido);
        response.setId(p.getId());
        return response;
    }

}
