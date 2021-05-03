package br.edu.ifsuldeminas.controller;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Apoiador;
import br.edu.ifsuldeminas.modelo.Atividade;
import br.edu.ifsuldeminas.modelo.Evento;



@ManagedBean
@ViewScoped
public class EventoController {
	
	private Evento evento = new Evento();
	private Integer apoiadorid;
	
	public Integer getApoiadorid() {
		return apoiadorid;
	}

	public void setApoiadorid(Integer apoiadorid) {
		this.apoiadorid = apoiadorid;
	}

	

	

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	
	public List<Atividade> getTodosAtividades(){
		return new Dao<Atividade>(Atividade.class).listaTodos();
	}
	
	public List<Apoiador> getTodosApoiadores(){
		return new Dao<Apoiador>(Apoiador.class).listaTodos();
	}
	
	public void gravar(){
		
		Dao<Evento> dao = new Dao<Evento>(Evento.class);
		
	
		
		Apoiador apoiadores = new Dao<Apoiador>(Apoiador.class).listaPorId(apoiadorid);
		evento.setApoiador(apoiadores);

		if(evento.getId()== null){
			dao.adiciona(evento);
			
		}else{
			dao.atualiza(evento);
		}
		
		evento = new Evento();
		
		apoiadorid = null;
	}
	
	
	public List<Evento> getTodosEventos(){
		return new Dao<Evento>(Evento.class).listaTodos();
	}
	
	public void carregar(Evento e){
		evento = e;
		apoiadorid = evento.getId();
	}
	
	public void remover(Evento e){
		new Dao<Evento>(Evento.class).remove(e.getId());
	}
	

}
