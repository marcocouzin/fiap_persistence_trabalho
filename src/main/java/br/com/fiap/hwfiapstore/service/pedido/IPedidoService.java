package br.com.fiap.hwfiapstore.service.pedido;


import br.com.fiap.hwfiapstore.entity.Pedido;

import java.util.List;

public interface IPedidoService {

     Pedido addPedido(Pedido Pedido);

     List<Pedido> getAllPedidos();

     Pedido getPedidoById(long id);

     List<Pedido> getPedidoByCodCliente(Long codCliente);
} 
