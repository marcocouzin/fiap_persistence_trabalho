package br.com.fiap.hwfiapstore.service.produto;


import br.com.fiap.hwfiapstore.entity.Produto;

import java.util.List;

public interface IProdutoService {
     List<Produto> getAllProdutos();
     Produto getProdutoById(long id);
     Produto addProduto(Produto produto);
     Produto updateProduto(Produto produto);
     void deleteProduto(long id);
} 
