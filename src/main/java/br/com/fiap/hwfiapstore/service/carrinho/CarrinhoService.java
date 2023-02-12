package br.com.fiap.hwfiapstore.service.carrinho;

import br.com.fiap.hwfiapstore.entity.Carrinho;
import br.com.fiap.hwfiapstore.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarrinhoService implements ICarrinhoService{

    private final CarrinhoRepository carrinhoRepository;

    @Autowired
    public CarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }


    @Override
    @Caching(
            evict= { @CacheEvict(value= "allCarrinhoCache", key = "#itemCarrinho.codCliente") }
    )
    public Carrinho addProdutoCarrinho(Carrinho itemCarrinho) {
        System.out.println("addProdutoCarrinho()");
        return this.carrinhoRepository.save(itemCarrinho);
    }


    @Override
    @Cacheable(value= "allCarrinhoCache", unless= "#result.size() == 0")
    public List<Carrinho> getCarrinhoByCodCliente(Long codCliente) {
        System.out.println("getCarrinhoByCodCliente()");
        return this.carrinhoRepository.findByCodCliente(codCliente);
    }


    @Override
    @Caching(evict= {@CacheEvict(value= "allCarrinhoCache", key = "#codCliente")}
    )
    public void deleteProdutoCarrinho(Long codProduto, Long codCliente) {
        System.out.println("getCarrinhoByCodProdutoAndCodCliente()");
        Carrinho itemCarrinho = this.carrinhoRepository.findByCodProdutoAndCodCliente(codProduto, codCliente);
        carrinhoRepository.deleteById(itemCarrinho.codCarrinho);
    }
}
