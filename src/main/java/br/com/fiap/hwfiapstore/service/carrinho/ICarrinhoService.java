package br.com.fiap.hwfiapstore.service.carrinho;

import br.com.fiap.hwfiapstore.entity.Carrinho;

import java.util.List;

public interface ICarrinhoService {

    Carrinho addProdutoCarrinho(Carrinho itemCarrinho);

    List<Carrinho> getCarrinhoByCodCliente(Long codCliente);

    void deleteProdutoCarrinho(Long codProduto, Long codCliente);
}
