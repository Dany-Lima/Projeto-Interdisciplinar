package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Atividade;
import br.edu.ifsuldeminas.modelo.Evento;
import br.edu.ifsuldeminas.modelo.Tipo;

@ManagedBean
@ViewScoped
public class AtividadeController {
	private Atividade atividade = new Atividade();
	
	private Integer eventoid;
	
	
	
	//pessoas cadastradas na atividade
	/*@ManyToMany
	private List<String> pessoascadastradas = new LinkedList<String>();
	

	public List<String> getPessoascadastradas() {
		return pessoascadastradas;
	}

	public void setPessoascadastradas(List<String> pessoascadastradas) {
		this.pessoascadastradas = pessoascadastradas;
	}

	*/
	
	public Integer getEventoid() {
		return eventoid;
	}

	public void setEventoid(Integer eventoid) {
		this.eventoid = eventoid;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	public List<Tipo> getTodosTipos(){
		return new Dao<Tipo>(Tipo.class).listaTodos();
	}
	
	
	public List<Evento> getTodosEventos(){
		return new Dao<Evento>(Evento.class).listaTodos();
	}
	
	//listar as pessoas cadastradas na atividade	
	/*public List<Pessoa> getTodasPessoa(){
		return new Dao<Pessoa>(Pessoa.class).listaTodos();
	}    */

	public void gravar(){
		
		Evento eventos= new Dao<Evento>(Evento.class).listaPorId(eventoid);
		atividade.setEvento(eventos);
		
		if(atividade.getId() == null){
			new Dao<Atividade>(Atividade.class).adiciona(atividade);
		} else {
			new Dao<Atividade>(Atividade.class).atualiza(atividade); 
		}
		atividade = new Atividade();
		eventoid=null;
	}	

	public void remover (Atividade a){
		 new Dao<Atividade>(Atividade.class).remove(a.getId());
	}
	
	public List<Atividade> getTodasAtividades(){
		return new Dao<Atividade>(Atividade.class).listaTodos();
	}
	
	public void carregar(Atividade a){
		atividade = a;
		eventoid =atividade.getId();
		
	}	
	
}
