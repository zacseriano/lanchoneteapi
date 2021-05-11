package com.zacseriano.lanchoneteapi.factories.impl;

import com.zacseriano.lanchoneteapi.factories.ProdutoFactory;
import com.zacseriano.lanchoneteapi.models.Produto;

public class ProdutoFactoryImpl implements ProdutoFactory {

	@Override
	public Produto criarProduto() {
			
		return new Produto();
	}

}


