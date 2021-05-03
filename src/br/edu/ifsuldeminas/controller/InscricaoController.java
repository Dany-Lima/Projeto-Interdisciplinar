package br.edu.ifsuldeminas.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.dao.InscricaoDao;
import br.edu.ifsuldeminas.modelo.Atividade;
import br.edu.ifsuldeminas.modelo.InscricaoAtividade;
import br.edu.ifsuldeminas.modelo.Inscricao;

@ManagedBean
@ViewScoped
public class InscricaoController {
	private Inscricao insc = new Inscricao();
	private Integer atividadeid;
	private int nvagas;
	
	public Inscricao getInsc() {
		return insc;
	}

	public void setInsc(Inscricao insc) {
		this.insc = insc;
	}

	public int getNvagas() {
		return nvagas;
	}

	public void setNvagas(int nvagas) {
		this.nvagas = nvagas;
	}

	public Inscricao getInscricao() {
		return insc;
	}

	public void setInscricao(Inscricao inscricao) {
		this.insc = inscricao;
	}

	public Integer getAtividadeid() {
		return atividadeid;
	}


	public void setAtividadeid(Integer atividadeid) {
		this.atividadeid = atividadeid;
	}

	public List<Atividade> getTodasAtividades(){
		return new Dao<Atividade>(Atividade.class).listaTodos();
	}
	
	
	
	public void gravarItem(){
		Atividade a = new Dao<Atividade>(Atividade.class).listaPorId(atividadeid);
		
		InscricaoAtividade inscricao = new InscricaoAtividade();
		inscricao.setAtividade(a);
		inscricao.setInscricao(insc);
		
		insc.add(inscricao);
		
		atividadeid = null;

	}
	
	public void gravar(){
		if (this.insc.getId() == null) {
			new Dao<Inscricao>(Inscricao.class).adiciona(insc);
		} else {
			new Dao<Inscricao>(Inscricao.class).atualiza(insc);
		}
		
		this.insc = new Inscricao();
	}
	
	public List<InscricaoAtividade> getiscricoes() {
		return insc.getAtividades();
	}

	public List<Inscricao> gettodasInscricoes(){
		return new Dao<Inscricao>(Inscricao.class).listaTodos();
	}
	
	public void remover(Inscricao i){
		new Dao<Inscricao>(Inscricao.class).remove(i.getId());
	}
	
	public void carregar(Inscricao i){
		
		insc = new InscricaoDao().listaPorId(i);
		
	}
	

}
