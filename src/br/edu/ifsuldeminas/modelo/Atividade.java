package br.edu.ifsuldeminas.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atividade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private int  qtdvagas;
	
	@Temporal(TemporalType.DATE)
	private Calendar data = Calendar.getInstance();
	
	private Integer tipoAtividadeId;
	
	
	@ManyToOne
	private Evento evento= new Evento();
	
	
	
	/*
	@ManyToMany
	private List<Pessoa> pessoa = new LinkedList<Pessoa>();	*/
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	/*
	public List<Pessoa> getPessoa() {
		return pessoa;
	}
	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;		
	} 		*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQtdvagas() {
		return qtdvagas;
	}
	public void setQtdvagas(int qtdvagas) {
		this.qtdvagas = qtdvagas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTipoAtividadeId() {
		return tipoAtividadeId;
	}

	public void setTipoAtividadeId(Integer tipoAtividadeId) {
		this.tipoAtividadeId = tipoAtividadeId;
	}
	
	
	//participante lista<pessoa>
	//gerenciador<pessoa>
	

}
