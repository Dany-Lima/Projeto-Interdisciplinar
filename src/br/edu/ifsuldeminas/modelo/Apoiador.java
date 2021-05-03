package br.edu.ifsuldeminas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity //cria a tabela no banco
public class Apoiador {
	
	@Id//incicar que id e chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//indicar que id e autoincremento
	private Integer id;
	
	private String nome;
	//atributo para imagem
	
	private String logo;
	
	@ManyToOne
	private CategoriaApoiador categoria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaApoiador getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaApoiador categoria) {
		this.categoria = categoria;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	

}
