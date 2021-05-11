package com.zacseriano.lanchoneteapi.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ITEM")

public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Produto produto;
	
	private BigDecimal quantidade;
	
	private BigDecimal valorItem;//MULTIPLICANDO O VALOR UNITARIO PELA QUANTIDADE NO FORMATO BIG DECIMAL
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="PEDIDO_ID")
	private Pedido pedido;
	
	public Item(){
		
	}
	
	public Item(Produto produto, BigDecimal quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorItem() {
		return valorItem;
	}

	public void setValorItem(BigDecimal valorItem) {
		this.valorItem = valorItem;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public BigDecimal defineValorItem(Produto produto, BigDecimal quantidade) {//CALCULA O VALOR DO ITEM RECEBENDO UM PRODUTO E UMA QUANTIDADE
		return produto.getValorUnitario().multiply(quantidade);
	}

}

