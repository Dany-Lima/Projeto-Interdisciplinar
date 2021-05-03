package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.ComissaoDao;
import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Comissao;
import br.edu.ifsuldeminas.modelo.ComissaoPessoa;
import br.edu.ifsuldeminas.modelo.Evento;
import br.edu.ifsuldeminas.modelo.Inscricao;
import br.edu.ifsuldeminas.modelo.Pessoa;


@ManagedBean
@ViewScoped
public class ComissaoController{
	
	public Comissao com = new Comissao();
	private Integer eventoId;
	private Integer pessoaId;
	private Pessoa pessoa = new Pessoa();
	
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Comissao getCom() {
		return com;
	}

	public void setCom(Comissao com) {
		this.com = com;
	}

	public Integer getEventoId() {
		return eventoId;
	}

	public void setEventoId(Integer eventoId) {
		this.eventoId = eventoId;
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public List<Comissao> getTodasComissoes(){
		return new Dao<Comissao>(Comissao.class).listaTodos();
	}
	
	public List<Evento> getTodosEventos(){
		return new Dao<Evento>(Evento.class).listaTodos();
	}
	
	public List<Pessoa> getTodosPessoas(){
		return new Dao<Pessoa>(Pessoa.class).listaTodos();
	}
	
	
public void gravar(){
		
		Dao<Comissao> dao = new Dao<Comissao>(Comissao.class);
		
		Evento evento= new Dao<Evento>(Evento.class).listaPorId(eventoId);
		com.setEvento(evento);

		if(com.getId()== null){
			dao.adiciona(com);
			
		}else{
			dao.atualiza(com);
		}
		
		com = new Comissao();
		eventoId = null;
	}	
	
	public void remover (Comissao c){
		 new Dao<Comissao>(Comissao.class).remove(c.getId());
	}
	
	public void carregar(Comissao c){	
		com = new ComissaoDao().listaPorId(com);	
	}
	
	
	
	public void gravarItem(){
		
		Evento e = new Dao<Evento>(Evento.class).listaPorId(eventoId);
		
		com.setEvento(e);
		new Dao<Comissao>(Comissao.class).adiciona(com);
		new Dao<Pessoa>(Pessoa.class).adiciona(pessoa);
		
		com.setPessoa(pessoa);
		pessoa.setComissao(com);
		
		com = new Comissao();
		eventoId= null;

	}	
	
	
	
	

}
