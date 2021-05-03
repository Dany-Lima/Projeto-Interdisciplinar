package br.edu.ifsuldeminas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifsuldeminas.modelo.Comissao;

public class ComissaoDao {
	
	public Comissao listaPorId(Comissao c) {
		EntityManager em = JPAUtil.getEntityManager();
		
		String jpql = "SELECT DISTINCT c FROM Comissao c LEFT JOIN FETCH c.pessoa WHERE c.id = :pId";
		
		TypedQuery<Comissao> query = em.createQuery(jpql, Comissao.class);
		query.setParameter("pId", c.getId());
		
		c = query.getSingleResult();
		
		em.close();
		
		return c;
	}
	
	

}
