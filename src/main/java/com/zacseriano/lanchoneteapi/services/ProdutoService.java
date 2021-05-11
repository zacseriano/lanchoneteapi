package com.zacseriano.lanchoneteapi.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zacseriano.lanchoneteapi.factories.ProdutoFactory;
import com.zacseriano.lanchoneteapi.factories.impl.ProdutoFactoryImpl;
import com.zacseriano.lanchoneteapi.models.Produto;

@Service
public class ProdutoService {
	private ProdutoFactory factory;
	
	private List<Produto> produtos;
	
	public void criarFactory() {
		if(factory == null) {
			factory = new ProdutoFactoryImpl();
		}
	}
	
	public void criarProdutoList() {
		if(produtos == null) {
			produtos = new ArrayList<>();
		}
	}
	
	public boolean isJSONValid(String jsonInString) {
	    try {
	       return new ObjectMapper().readTree(jsonInString) != null;
	    } catch (IOException e) {
	       return false;
	    }
	}
	
	private long parseprodutoId(JSONObject produto) {
		return Long.valueOf((int) produto.get("produtoId"));
	}
	
	private BigDecimal parseEstoque(JSONObject produto) {
		return new BigDecimal((String) produto.get("estoque"));
	}
	
	private BigDecimal parseValorUnitario(JSONObject produto) {
		return new BigDecimal((String) produto.get("valorUnitario"));
	}
	
	/*private void setProdutoValues(JSONObject jsonTravel, Produto produto) {
		
		String nome = (String) jsonTravel.get("nome");
		String categoria = (String) jsonTravel.get("categoria");
		
		produto.setProdutoId(produtoId != null ? orderNumber : produto.getOrderNumber());
		produto.setAmount(jsonTravel.get("amount") != null ? parseAmount(jsonTravel) : produto.getAmount());
		produto.setStartDate(jsonTravel.get("startDate") != null ? parseStartDate(jsonTravel) : produto.getStartDate());
		produto.setEndDate(jsonTravel.get("endDate") != null ? parseEndDate(jsonTravel) : produto.getEndDate());
		produto.setType(type != null ? TravelTypeEnum.getEnum(type) : produto.getType());
	}*/
}
