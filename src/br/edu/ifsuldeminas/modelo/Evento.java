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
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//indicar que id e autoincremento
	private Integer Id;
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Calendar dtinic = Calendar.getInstance();
	private Calendar dtfi = Calendar.getInstance();
	
	private String programacao;
	private String mapa;
	

	
	@ManyToOne
	private Apoiador apoiador = new Apoiador();
	
	
	//private Comisao comissao;

	
	
	public Apoiador getApoiador() {
		return apoiador;
	}
	public void setApoiador(Apoiador apoiador) {
		this.apoiador = apoiador;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Calendar getDtinic() {
		return dtinic;
	}
	public void setDtinic(Calendar dtinic) {
		this.dtinic = dtinic;
	}
	public Calendar getDtfi() {
		return dtfi;
	}
	public void setDtfi(Calendar dtfi) {
		this.dtfi = dtfi;
	}
	public String getMapa() {
		return mapa;
	}
	public String getProgramacao() {
		return programacao;
	}
	public void setProgramacao(String programacao) {
		this.programacao = programacao;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}
	

}
