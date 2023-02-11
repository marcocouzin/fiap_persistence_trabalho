package br.com.fiap.hwfiapstore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "itenspedido")
public class ItensPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public int quantity;

    @ManyToOne
    private Pedido order;

    @ManyToOne
    public Produto product;
}
