package br.com.fiap.hwfiapstore.service.cliente;

import br.com.fiap.hwfiapstore.entity.Cliente;
import br.com.fiap.hwfiapstore.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
	@Cacheable(value= "clienteCache", key= "#id")		
	public Cliente getClienteById(long id) {
		System.out.println("getClienteById()");		
		return clienteRepository.findById(id).get();
	}

	@Override
	@Caching(
			put= { @CachePut(value= "clienteCache", key= "#cliente.codCliente") },
			evict= { @CacheEvict(value= "allClientesCache", allEntries= true) }
	)
	public Cliente addCliente(Cliente cliente){
		System.out.println("addCliente()");
		return clienteRepository.save(cliente);
	}


	@Override	
	@Cacheable(value= "allClientesCache", unless= "#result.size() == 0")	
	public List<Cliente> getAllClientes(){
		System.out.println("getAllClientes()");
		List<Cliente> lista = new ArrayList<>();
		clienteRepository.findAll().forEach(lista::add);
		return lista;
	}

	@Override
	@Caching(
		put= { @CachePut(value= "clienteCache", key= "#cliente.id") },
		evict= { @CacheEvict(value= "allClientesCache", allEntries= true) }
	)
	public Cliente updateCliente(Cliente cliente) {
		System.out.println("addCliente()");		
		return clienteRepository.save(cliente);
	}

	@Override	
	@Caching(
		evict= { 
			@CacheEvict(value= "clienteCache", key= "#id"),
			@CacheEvict(value= "allClientesCache", allEntries= true)
		}
	)

	public void deleteCliente(long id) {
		System.out.println("deleteCliente()");		
		clienteRepository.delete(clienteRepository.findById(id).get());
	}
} 
