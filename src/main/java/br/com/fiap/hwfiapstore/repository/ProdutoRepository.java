package br.com.fiap.hwfiapstore.repository;

import br.com.fiap.hwfiapstore.entity.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
