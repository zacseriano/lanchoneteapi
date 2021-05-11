package com.zacseriano.lanchoneteapi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PEDIDO")
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;		
	
	@OneToMany
	@JoinColumn(name="PEDIDO_ID")
	private List<Item> item;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="CLIENTE_ID")
	private Cliente cliente;

	public Pedido(){
		
	}	

	public Pedido(Cliente cliente, Item item) {
		this.cliente = cliente;
		this.item = new ArrayList<Item>();
		this.item.add(item);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> itens) {
		this.item = itens;
	}		
	
	public void addItem(Item item) {
		this.item.add(item);		
	}
}