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

import com.zacseriano.lanchoneteapi.models.Produto;
import com.zacseriano.lanchoneteapi.repositories.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")//MOSTRA A LISTA DE PRODUTOS
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")//MOSTRA UM PRODUTO EM ESPECÍFICO
	public Produto listaProduto(@PathVariable(value="id")long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")//SALVA UM PRODUTO NO BANCO DE DADOS
	public Produto salvaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")//SALVA UM PRODUTO NO BANCO DE DADOS
	public void deletaProduto(@RequestBody @Valid Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")//SALVA UM PRODUTO NO BANCO DE DADOS
	public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}
			
}