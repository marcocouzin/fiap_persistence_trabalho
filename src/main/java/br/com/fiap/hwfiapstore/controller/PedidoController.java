package br.com.fiap.hwfiapstore.controller;

import br.com.fiap.hwfiapstore.entity.Pedido;
import br.com.fiap.hwfiapstore.service.pedido.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    private final IPedidoService pedidoService;

    @Autowired
    public PedidoController(IPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @PostMapping("addpedido")
    public ResponseEntity<Void> addPedido(@RequestBody Pedido pedido, UriComponentsBuilder builder) {
        Pedido savedPedido = pedidoService.addPedido(pedido);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/pedido/{id}").buildAndExpand(savedPedido.codPedido).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("listapedidos")
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> lista = pedidoService.getAllPedidos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
