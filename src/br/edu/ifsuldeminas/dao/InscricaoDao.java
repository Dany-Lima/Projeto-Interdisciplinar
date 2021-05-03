package br.edu.ifsuldeminas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifsuldeminas.modelo.Inscricao;

public class InscricaoDao {
	
	public Inscricao listaPorId(Inscricao c) {
		EntityManager em = JPAUtil.getEntityManager();
		
		String jpql = "SELECT DISTINCT c FROM Inscricao c LEFT JOIN FETCH c.atividades WHERE c.id = :pId";
		
		TypedQuery<Inscricao> query = em.createQuery(jpql, Inscricao.class);
		query.setParameter("pId", c.getId());
		
		c = query.getSingleResult();
		
		em.close();
		
		return c;
	}
	
	

}
