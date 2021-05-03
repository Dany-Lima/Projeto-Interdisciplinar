package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Apoiador;
import br.edu.ifsuldeminas.modelo.CategoriaApoiador;

@ManagedBean
@ViewScoped
public class ApoiadorController {
	
	private Apoiador apoiador = new Apoiador();
	
	private Integer categoria;
	
	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	
	public List<CategoriaApoiador> getTodasCategorias(){
		return new Dao<CategoriaApoiador>(CategoriaApoiador.class).listaTodos();
	}

	public Apoiador getApoiador() {
		return apoiador;
	}

	public void setApoiador(Apoiador apoiador) {
		this.apoiador = apoiador;
	}
	
	
	public void gravar(){
		Dao<Apoiador> dao = new Dao<Apoiador>(Apoiador.class);
		CategoriaApoiador c = new Dao<CategoriaApoiador>(CategoriaApoiador.class).listaPorId(categoria);
		
		apoiador.setCategoria(c);
		
		if(apoiador.getId() == null){
			dao.adiciona(apoiador);
		}else{
			dao.atualiza(apoiador);
		}
		
		apoiador = new Apoiador();
		categoria = null;
	}
	
	
	public List<Apoiador> getTodosApoiadores(){
		return new Dao<Apoiador>(Apoiador.class).listaTodos();
	}
	
	public void carregar(Apoiador a){
		apoiador = a;
		
	}
	
	public void remover(Apoiador a){
		new Dao<Apoiador>(Apoiador.class).remove(a.getId());
	}

}
