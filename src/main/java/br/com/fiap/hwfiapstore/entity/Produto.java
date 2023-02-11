package br.com.fiap.hwfiapstore.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long codProduto;
	public String name;
	public String description;
	public BigDecimal price;
}
