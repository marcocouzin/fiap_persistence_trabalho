package br.com.fiap.hwfiapstore.service.cliente;

import br.com.fiap.hwfiapstore.entity.Cliente;
import br.com.fiap.hwfiapstore.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService implements IClienteService {
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override	
	public Cliente getClienteById(long id) {
		System.out.println("getClienteById()");		
		return clienteRepository.findById(id).get();
	}

	@Override
	public Cliente addCliente(Cliente cliente){
		System.out.println("addCliente()");
		return clienteRepository.save(cliente);
	}


	@Override	
	public List<Cliente> getAllClientes(){
		System.out.println("getAllClientes()");
		List<Cliente> lista = new ArrayList<>();
		clienteRepository.findAll().forEach(lista::add);
		return lista;
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		System.out.println("addCliente()");		
		return clienteRepository.save(cliente);
	}

	@Override
	public void deleteCliente(long id) {
		System.out.println("deleteCliente()");		
		clienteRepository.delete(clienteRepository.findById(id).get());
	}
} 
