package br.edu.ifsuldeminas.modelo;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Inscricao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private int numvagas;
	
	@Temporal(TemporalType.DATE)
	private Calendar dtinscricaoinic = Calendar.getInstance();
	
	@Temporal(TemporalType.DATE)
	private Calendar dtinscricaofim = Calendar.getInstance();
	

	// cascade ALL: ao inserir, alterar e remover cascade 
	@OneToMany(mappedBy="inscricao", cascade= CascadeType.ALL, orphanRemoval = true)
	
	
	private List<InscricaoAtividade> atividades = new LinkedList<InscricaoAtividade>();
	
	public void add(InscricaoAtividade inscricao) {
		this.atividades.add(inscricao);
	}
	
	
	public int getValorTotal() {
		
		return numvagas;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getNumvagas() {
		return numvagas;
	}

	public void setNumvagas(int numvagas) {
		this.numvagas = numvagas;
	}

	public Calendar getDtinscricaoinic() {
		return dtinscricaoinic;
	}

	public void setDtinscricaoinic(Calendar dtinscricaoinic) {
		this.dtinscricaoinic = dtinscricaoinic;
	}

	public Calendar getDtinscricaofim() {
		return dtinscricaofim;
	}

	public void setDtinscricaofim(Calendar dtinscricaofim) {
		this.dtinscricaofim = dtinscricaofim;
	}

	public List<InscricaoAtividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<InscricaoAtividade> atividades) {
		this.atividades = atividades;
	}

	

}
