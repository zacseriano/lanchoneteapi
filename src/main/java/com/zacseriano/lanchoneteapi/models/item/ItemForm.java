package com.zacseriano.lanchoneteapi.models.item;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/**
 * Classe que é implementada com três campos, passando um valor que indica a quantidade do Produto, um Id de Produto
 * e um email de Cliente como informações no formulário utilizado no RequestBody dos seguintes 
 * métodos de endpoints:
 *   	- salvaPrimeiroItem() no /cliente/solicitarPedido
 *  	- salvaOutroItem() no /cliente/solicitarPedido
 */
public class ItemForm {
	
	@NotNull(message="A quantidade não pode estar vazia.")
	private BigDecimal quantidade;
	
	@NotNull(message="O Id do Produto não pode estar vazio.")
	private long produtoId;
	
	@NotNull(message="O email do Cliente não pode estar vazio.")
	private String clienteEmail;
	
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(long produtoId) {
		this.produtoId = produtoId;
	}
	public String getClienteEmail() {
		return clienteEmail;
	}
	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}
}