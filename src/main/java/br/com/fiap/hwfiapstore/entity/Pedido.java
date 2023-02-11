package br.com.fiap.hwfiapstore.entity;

// https://stackoverflow.com/questions/70183406/spring-boot-cant-get-a-list-of-objects-which-this-object-is-related-to-another

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long codPedido;
//    public Date date;
    public boolean paid;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    public List<ItensPedido> itenspedido;
}
