package com.zacseriano.lanchoneteapi.resources;

import java.util.List;

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
import com.zacseriano.lanchoneteapi.models.ClienteForm;
import com.zacseriano.lanchoneteapi.repositories.ClienteRepository;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/gerenciarClientes")//MOSTRA A LISTA DE PRODUTOS
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")//MOSTRA UM PRODUTO EM ESPECÍFICO
	public Cliente listaCliente(@PathVariable(value="id")long id){
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/gerenciarClientes")//SALVA UM PRODUTO NO BANCO DE DADOS
	public Cliente salvaCliente(@RequestBody @Valid ClienteForm clienteForm) {
		Cliente cliente = new Cliente(clienteForm.getNome(), clienteForm.getEndereco(), clienteForm.getEmail());
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/gerenciarClientes")//SALVA UM PRODUTO NO BANCO DE DADOS
	public void deletaCliente(@RequestBody @Valid Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	@PutMapping("/gerenciarClientes")//SALVA UM PRODUTO NO BANCO DE DADOS
	public Cliente atualizaCliente(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}
			
}
