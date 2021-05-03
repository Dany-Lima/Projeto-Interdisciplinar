package br.edu.ifsuldeminas.utils;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.CategoriaApoiador;

public class InsereCategoriaApoiador {
	
	public static void main(String[] args) {
		CategoriaApoiador t1 = new CategoriaApoiador();
		t1.setNome("Ouro");
		
		CategoriaApoiador t2 = new CategoriaApoiador();
		t2.setNome("Prata");
		
		CategoriaApoiador t3 = new CategoriaApoiador();
		t3.setNome("Bronze");
		
		Dao<CategoriaApoiador> dao = new Dao<CategoriaApoiador>(CategoriaApoiador.class);
		dao.adiciona(t1);
		dao.adiciona(t2);
		dao.adiciona(t3);
	}
}
