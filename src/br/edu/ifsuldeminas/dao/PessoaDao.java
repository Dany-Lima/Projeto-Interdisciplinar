package br.edu.ifsuldeminas.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import br.edu.ifsuldeminas.modelo.Pessoa;
import br.edu.ifsuldeminas.utils.Utils;

public class PessoaDao {
	
	public Pessoa buscarPorEmailESenha(String email, String senha) {
		Pessoa usuario;
		
		String jpql = "SELECT f FROM Pessoa f WHERE f.email = :pemail AND f.senha = :psenha";
				
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Pessoa> query = em.createQuery(jpql, Pessoa.class);
		query.setParameter("pemail", email);
		query.setParameter("psenha",senha);
		
		try {
			usuario = query.getSingleResult();
	    } catch (NoResultException ex) {
	        usuario = null;
	    }
		
		em.close();
		
		return usuario;
	}
	
//	public static void main(String[] args) {
//		Funcionario f = new FuncionarioDao().buscarPorEmailESenha("aline.valle", "123");
//		System.out.println(f.getNome() + ": " + f.getLogin() + ", " + f.getSenha());
//		System.out.println(f.getGrupo().getNome());
//		for (Funcionalidade fu : f.getGrupo().getFuncionalidades()) {
//			System.out.println(fu.getNome() + ", " + fu.getPagina());
//		}
//	}
}
