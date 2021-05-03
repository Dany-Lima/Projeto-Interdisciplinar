package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Faq;

@ManagedBean
@ViewScoped
public class FaqController {
	
	
	private Faq faq = new Faq();
	
	
	public Faq getFaq() {
		return faq;
	}

	public void setFaq(Faq faq) {
		this.faq = faq;
	}

	public void gravar(){
		Dao<Faq> dao = new Dao<Faq>(Faq.class);
		
		if(faq.getId() == null){
			dao.adiciona(faq);
		}else{
			dao.atualiza(faq);
		}
		
		faq = new Faq();

	}
	
	public List<Faq> getTodosFaqs(){
		return new Dao<Faq>(Faq.class).listaTodos();
	}
	
	public void carregar(Faq f){
		faq = f;
		
	}
	
	
	public void remover(Faq f){
		new Dao<Faq>(Faq.class).remove(f.getId());
	}
	
	
	

}
