package br.com.fiap.hwfiapstore.repository;

import br.com.fiap.hwfiapstore.entity.Carrinho;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Long> {
    List<Carrinho> findByCodCliente(Long codCliente);
    Carrinho findByCodProdutoAndCodCliente(Long codProduto, Long codCliente);
}
