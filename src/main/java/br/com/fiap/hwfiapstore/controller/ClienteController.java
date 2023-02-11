package br.com.fiap.hwfiapstore.controller;

import br.com.fiap.hwfiapstore.entity.Cliente;
import br.com.fiap.hwfiapstore.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    private final IClienteService clienteService;

    @Autowired
    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping("greeting")
    public String greeting() {
        return "Welcome to client API!";
    }

    @PostMapping("cliente")
    public ResponseEntity<Void> addCliente(@RequestBody Cliente cliente, UriComponentsBuilder builder) {
        Cliente savedCliente = clienteService.addCliente(cliente);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/cliente/{id}").buildAndExpand(savedCliente.codCliente).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("clientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> lista = clienteService.getAllClientes();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PutMapping("cliente")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
        clienteService.updateCliente(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}
