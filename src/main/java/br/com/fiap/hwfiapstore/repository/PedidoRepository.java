package br.com.fiap.hwfiapstore.repository;

import br.com.fiap.hwfiapstore.entity.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{
    List<Pedido> findByCodCliente(Long codCliente);
}
