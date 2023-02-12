package br.com.fiap.hwfiapstore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long codPedido;

    @Column(name = "codCliente", insertable = false, updatable = false)
    public long codCliente;

    @ManyToOne
    @JoinColumn(name = "codCliente")
    public Cliente cliente;


    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    public List<ItensPedido> itenspedido;

    public boolean paid;
}
