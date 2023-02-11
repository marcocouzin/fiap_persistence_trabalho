package br.com.fiap.hwfiapstore.service.cliente;


import br.com.fiap.hwfiapstore.entity.Cliente;

import java.util.List;

public interface IClienteService {
     List<Cliente> getAllClientes();
     Cliente getClienteById(long id);
     Cliente addCliente(Cliente Cliente);
     Cliente updateCliente(Cliente Cliente);
     void deleteCliente(long id);
} 
