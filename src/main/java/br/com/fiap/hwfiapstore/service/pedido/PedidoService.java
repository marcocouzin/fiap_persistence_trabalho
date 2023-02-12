package br.com.fiap.hwfiapstore.service.pedido;

import br.com.fiap.hwfiapstore.entity.Carrinho;
import br.com.fiap.hwfiapstore.entity.Cliente;
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
	public Pedido addPedido(Pedido pedido){
		System.out.println("addPedido()");
		return pedidoRepository.save(pedido);
	}



	@Override
	public List<Pedido> getAllPedidos(){
		System.out.println("getAllPedidos()");
		List<Pedido> lista = new ArrayList<>();
		pedidoRepository.findAll().forEach(lista::add);
		return lista;
	}


	@Override
	public Pedido getPedidoById(long codPedido) {
		System.out.println("getPedidoById()");
		return pedidoRepository.findById(codPedido).get();
	}


	public List<Pedido> getPedidoByCodCliente(Long codCliente) {
		System.out.println("getPedidoByCodCliente()");
		return this.pedidoRepository.findByCodCliente(codCliente);
	}
}
