package br.edu.ifsuldeminas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.edu.ifsuldeminas.modelo.InscricaoAtividade;
import br.edu.ifsuldeminas.modelo.Inscricao;

public class InscricaoAtividadeDao {
	
	public List<InscricaoAtividade> listaPorInscricao(Inscricao c) {
		EntityManager em = JPAUtil.getEntityManager();
		
		String jpql = "SELECT i FROM InscricaoAtividade i WHERE i.inscricao = :pInscricao";
		
		TypedQuery<InscricaoAtividade> query = em.createQuery(jpql, InscricaoAtividade.class);
		query.setParameter("pInscricao", c);
		
		List<InscricaoAtividade> lista = query.getResultList();
		
		em.close();
		
		return lista;
	}

	
	

}
