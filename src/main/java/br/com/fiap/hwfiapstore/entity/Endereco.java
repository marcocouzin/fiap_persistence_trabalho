package br.com.fiap.hwfiapstore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Endereco", catalog = "hwshop")
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long codEndereco;

    @Column(name = "cep", nullable = false)
    public String cep;

    @Column(name = "logradouro", nullable = false)
    public String logradouro;

    @Column(name = "numero", nullable = false)
    public Integer numero;

    @Column(name = "bairro", nullable = false)
    public String bairro;

    @Column(name = "cidade", nullable = false)
    public String cidade;

    @Column(name = "estado", nullable = false)
    public String estado;
}
