package br.com.fiap.hwfiapstore.service.produto;

import br.com.fiap.hwfiapstore.entity.Produto;
import br.com.fiap.hwfiapstore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService implements IProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override	
	public Produto getProdutoById(long id) {
		System.out.println("getProdutoById()");		
		return produtoRepository.findById(id).get();
	}
	@Override	
	public List<Produto> getAllProdutos(){
		System.out.println("getAllProdutos()");
		List<Produto> lista = new ArrayList<>();
		produtoRepository.findAll().forEach(e -> lista.add(e));
		return lista;
	}
	@Override
	public Produto addProduto(Produto produto){
		System.out.println("addProduto()");		
		return produtoRepository.save(produto);
	}
	@Override
	public Produto updateProduto(Produto produto) {
		System.out.println("addProduto()");		
		return produtoRepository.save(produto);
	}
	@Override
	public void deleteProduto(long id) {
		System.out.println("deleteProduto()");		
		produtoRepository.delete(produtoRepository.findById(id).get());
	}
} 
