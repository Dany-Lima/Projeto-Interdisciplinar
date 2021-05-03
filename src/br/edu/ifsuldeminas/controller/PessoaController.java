package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Grupo;
import br.edu.ifsuldeminas.modelo.Pessoa;
import br.edu.ifsuldeminas.modelo.Sexo;

@ManagedBean
@ViewScoped
public class PessoaController {
	private Pessoa pessoa = new Pessoa();

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	

	public List<Pessoa> getTodasPessoas(){
		return new Dao<Pessoa>(Pessoa.class).listaTodos();
	}
	
	public List<Sexo> getTodosSexos(){
		return new Dao<Sexo>(Sexo.class).listaTodos();
	}
	
	public List<Grupo> getTodosGrupos(){
		return new Dao<Grupo>(Grupo.class).listaTodos();
	}
	
	
	public void gravar(){
		if(pessoa.getId() == null){
			new Dao<Pessoa>(Pessoa.class).adiciona(pessoa);
		} else {
			new Dao<Pessoa>(Pessoa.class).atualiza(pessoa); 
		}
		pessoa = new Pessoa();
	}
	
	public void remover (Pessoa p){
		 new Dao<Pessoa>(Pessoa.class).remove(p.getId());
	}
	
	public void carregar(Pessoa p){
		pessoa = p;
	}


}
