package br.com.fiap.hwfiapstore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long codCliente;

    @Column(name = "email", unique = true, nullable = false)
    public String email;

    @Column(name = "senha", nullable = false)
    public String senha;

    @Column(name = "nome", nullable = false)
    public String nome;

    @Column(name = "cpf", unique = true, nullable = false)
    public Long cpf;

    @Column(name = "telefone", nullable = false)
    public String telefone;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Cliente_Endereco", catalog = "hwshop", joinColumns = {
            @JoinColumn(name = "codCliente", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "codEndereco", nullable = false, updatable = false) })
    public Set<Endereco> enderecos = new HashSet<>();
}
