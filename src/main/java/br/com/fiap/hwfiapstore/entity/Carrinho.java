package br.com.fiap.hwfiapstore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "carrinho")
public class Carrinho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long codCarrinho;
    public long codProduto;
    public long codCliente;
    public String name;
    public String description;
    public BigDecimal price;
    public int quantity;
}
