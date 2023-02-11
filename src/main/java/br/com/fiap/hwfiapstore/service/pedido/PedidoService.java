package br.com.fiap.hwfiapstore.service.pedido;

import br.com.fiap.hwfiapstore.entity.Pedido;
import br.com.fiap.hwfiapstore.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService implements IPedidoService {
	private final PedidoRepository pedidoRepository;

	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@Override
	@Cacheable(value= "pedidoCache", key= "#id")
	public Pedido getPedidoById(long id) {
		System.out.println("getPedidoById()");
		return pedidoRepository.findById(id).get();
	}

	@Override
	@Caching(
			put= { @CachePut(value= "pedidoCache", key= "#pedido.codPedido") },
			evict= { @CacheEvict(value= "allPedidosCache", allEntries= true) }
	)
	public Pedido addPedido(Pedido pedido){
		System.out.println("addPedido()");
		return pedidoRepository.save(pedido);
	}


	@Override
	@Cacheable(value= "allPedidosCache", unless= "#result.size() == 0")
	public List<Pedido> getAllPedidos(){
		System.out.println("getAllPedidos()");
		List<Pedido> lista = new ArrayList<>();
		pedidoRepository.findAll().forEach(lista::add);
		return lista;
	}

	@Override
	@Caching(
		put= { @CachePut(value= "pedidoCache", key= "#pedido.id") },
		evict= { @CacheEvict(value= "allPedidosCache", allEntries= true) }
	)
	public Pedido updatePedido(Pedido pedido) {
		System.out.println("addPedido()");
		return pedidoRepository.save(pedido);
	}

	@Override
	@Caching(
		evict= {
			@CacheEvict(value= "pedidoCache", key= "#id"),
			@CacheEvict(value= "allPedidosCache", allEntries= true)
		}
	)

	public void deletePedido(long id) {
		System.out.println("deletePedido()");
		pedidoRepository.delete(pedidoRepository.findById(id).get());
	}
}
