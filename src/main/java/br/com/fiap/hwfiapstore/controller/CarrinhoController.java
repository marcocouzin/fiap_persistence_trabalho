package br.com.fiap.hwfiapstore.controller;

import br.com.fiap.hwfiapstore.entity.Carrinho;
import br.com.fiap.hwfiapstore.service.carrinho.ICarrinhoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("carrinho")
public class CarrinhoController {
    private final ICarrinhoService carrinhoService;

    public CarrinhoController(ICarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @RequestMapping("greeting")
    public String greeting() {
        return "Welcome to cart API!";
    }


    @PostMapping("additem")
    public ResponseEntity<Void> addCarrinho(@RequestBody Carrinho carrinho, UriComponentsBuilder builder) {
        Carrinho savedCart = this.carrinhoService.addProdutoCarrinho(carrinho);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/carrinho/{id}").buildAndExpand(savedCart.codCarrinho).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @DeleteMapping("item/{codProduto}/{codCliente}")
    public ResponseEntity<Void> deleteArticle(
            @PathVariable("codProduto") Long codProduto,
            @PathVariable("codCliente") Long codCliente) {
        this.carrinhoService.deleteProdutoCarrinho(codProduto, codCliente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/itens/{codCliente}")
    public ResponseEntity<List<Carrinho>> getItensCarrinho(@PathVariable("codCliente") Long codCliente) {
        return new ResponseEntity<>(this.carrinhoService.getCarrinhoByCodCliente(codCliente), HttpStatus.OK);
    }
}
