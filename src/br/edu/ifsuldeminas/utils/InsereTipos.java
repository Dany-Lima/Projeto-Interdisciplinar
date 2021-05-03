package br.edu.ifsuldeminas.utils;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Tipo;

public class InsereTipos {
	
	public static void main(String[] args) {
		Tipo t1 = new Tipo();
		t1.setNome("Mini curso");
		
		Tipo t2 = new Tipo();
		t2.setNome("Palestra");
		
		Tipo t3 = new Tipo();
		t3.setNome("Workshop");
		
		Tipo t4 = new Tipo();
		t4.setNome("Entreterimento");
		
		Tipo t5 = new Tipo();
		t5.setNome("Outros");
		
		Dao<Tipo> dao = new Dao<Tipo>(Tipo.class);
		dao.adiciona(t1);
		dao.adiciona(t2);
		dao.adiciona(t3);
		dao.adiciona(t4);
		dao.adiciona(t5);	
	
	}
}
