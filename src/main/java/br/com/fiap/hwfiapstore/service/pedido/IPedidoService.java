package br.com.fiap.hwfiapstore.service.pedido;


import br.com.fiap.hwfiapstore.entity.Pedido;

import java.util.List;

public interface IPedidoService {

     List<Pedido> getAllPedidos();

     Pedido getPedidoById(long id);

     Pedido addPedido(Pedido Pedido);

     Pedido updatePedido(Pedido Pedido);

     void deletePedido(long id);
} 
