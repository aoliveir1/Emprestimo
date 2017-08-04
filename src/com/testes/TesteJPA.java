package com.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteJPA {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("C8");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		// Exclui todos emprestimos
	
//		Query  q;
//		q = em.createQuery("delete from Emprestimo emp");
//		q.executeUpdate();
//		
//		em.flush();
//
//		// Cadastra e busca emprestimo
//		Emprestimo e = new Emprestimo("", "", "", "", (new Date()).toString(), "");
//		em.persist(e);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
