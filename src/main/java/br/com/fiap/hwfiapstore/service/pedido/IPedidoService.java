package br.com.fiap.hwfiapstore.service.pedido;


import br.com.fiap.hwfiapstore.entity.Pedido;

import java.util.List;

public interface IPedidoService {

     Pedido addPedido(Pedido Pedido);

     List<Pedido> getAllPedidos();

//     List<Pedido> getPedidoByCliente(long codCliente);

     Pedido getPedidoById(long id);


     Pedido updatePedido(Pedido Pedido);
} 
