package br.edu.ifsuldeminas.utils;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Grupo;

public class InsereGrupo {
	
	public static void main(String[] args) {
		Dao<Grupo> dao = new Dao<Grupo>(Grupo.class);
		
		Grupo f1 = new Grupo();
		f1.setNome("participante");
		
		Grupo f2 = new Grupo();
		f2.setNome("administrador");
		
		dao.adiciona(f1);
		dao.adiciona(f2);
	}

}
