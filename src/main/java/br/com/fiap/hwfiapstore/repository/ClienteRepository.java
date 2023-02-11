package br.com.fiap.hwfiapstore.repository;

import br.com.fiap.hwfiapstore.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
