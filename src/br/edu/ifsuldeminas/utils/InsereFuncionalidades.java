package br.edu.ifsuldeminas.utils;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Funcionalidade;

public class InsereFuncionalidades {
	
	//inserir as funcionalidades dos usuarios: cadastrar atividade, fazer inscrição...
	
	public static void main(String[] args) {
		Dao<Funcionalidade> dao = new Dao<Funcionalidade>(Funcionalidade.class);
		
		Funcionalidade f1 = new Funcionalidade();
		f1.setNome("");
		
		Funcionalidade f2 = new Funcionalidade();
		f2.setNome("");
		
		dao.adiciona(f1);
		dao.adiciona(f2);
	}

}
