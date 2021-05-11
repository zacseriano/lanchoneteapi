package com.zacseriano.lanchoneteapi.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zacseriano.lanchoneteapi.models.Cliente;
import com.zacseriano.lanchoneteapi.models.Item;
import com.zacseriano.lanchoneteapi.models.ItemBrabo;
import com.zacseriano.lanchoneteapi.models.Pedido;
import com.zacseriano.lanchoneteapi.models.Produto;
import com.zacseriano.lanchoneteapi.repositories.ClienteRepository;
import com.zacseriano.lanchoneteapi.repositories.ItemRepository;
import com.zacseriano.lanchoneteapi.repositories.PedidoRepository;
import com.zacseriano.lanchoneteapi.repositories.ProdutoRepository;

@RestController
@RequestMapping(value="/pedido")
public class PedidoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping("/selecionarItens")//ADICIONA O PRIMEIRO ITEM
	public Pedido salvaPrimeiroItem(@RequestBody @Valid ItemBrabo brabo) {
		
		Produto produto = produtoRepository.findById(brabo.getProdutoId());
		Item item = new Item(produto, brabo.getQuantidade());
		item.setValorItem(item.defineValorItem(produto, item.getQuantidade()));
		itemRepository.save(item);
		Cliente cliente = clienteRepository.findById(brabo.getClienteId());
		Pedido pedido = new Pedido(cliente, item);
		item.setPedido(pedido);
		return pedidoRepository.save(pedido);	
	}
	
	@GetMapping("/{id}")//MOSTRA UM PRODUTO EM ESPECÍFICO
	public Pedido listaPedido(@PathVariable(value="id")long id){
		return pedidoRepository.findById(id);
	}
	
	@PutMapping("/selecionarItens")//ADICIONA O PRIMEIRO ITEM
	public void salvaOutroItem(@RequestBody @Valid long pedidoId, ItemBrabo itemB) {
		
		Pedido pedido = pedidoRepository.findById(pedidoId);
		Produto produto = produtoRepository.findById(itemB.getProdutoId());
		Item item = new Item(produto, itemB.getQuantidade());
		item.setValorItem(item.defineValorItem(produto, item.getQuantidade()));
		pedido.addItem(item);
		
		pedidoRepository.save(pedido);	
	}	
		
	@DeleteMapping("/selecionarItens")//ADICIONA O PRIMEIRO ITEM
	public void deletarPedido(@RequestBody @Valid long pedidoId) {
		
		Pedido pedido = pedidoRepository.findById(pedidoId);
		
		pedidoRepository.delete(pedido);	
	}

}
