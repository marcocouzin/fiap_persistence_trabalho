package br.com.fiap.hwfiapstore.controller;

import br.com.fiap.hwfiapstore.entity.Produto;
import br.com.fiap.hwfiapstore.service.produto.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private final IProdutoService produtoService;

    @Autowired
    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @PostMapping("produto")
    public ResponseEntity<Void> addProduto(@RequestBody Produto produto, UriComponentsBuilder builder) {
        Produto savedProduto = produtoService.addProduto(produto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/produto/{id}").buildAndExpand(savedProduto.codProduto).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("produto/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id) {
        Produto produto = produtoService.getProdutoById(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping("produtos")
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> lista = produtoService.getAllProdutos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PutMapping("produto")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
        produtoService.updateProduto(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
}
