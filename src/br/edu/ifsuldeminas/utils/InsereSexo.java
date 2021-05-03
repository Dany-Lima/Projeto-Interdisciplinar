package br.edu.ifsuldeminas.utils;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Sexo;

public class InsereSexo {
	
	public static void main(String[] args) {
		Sexo t1 = new Sexo();
		t1.setNome("Feminino");
		
		Sexo t2 = new Sexo();
		t2.setNome("Masculino");
		
		Sexo t3 = new Sexo();
		t3.setNome("Outro");
		
		Dao<Sexo> dao = new Dao<Sexo>(Sexo.class);
		dao.adiciona(t1);
		dao.adiciona(t2);
		dao.adiciona(t3);
	}
}
