package com.ejb.session;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.intf.EmprestimoSession;
import com.model.ejb.entity.Emprestimo;

@Stateless
public class EmprestimoSessionBean implements EmprestimoSession {

	@PersistenceContext(unitName = "C8")
	private EntityManager em;

	@Override
	public void remove(Emprestimo e) {
		Emprestimo emprestimo = em.find(Emprestimo.class, e.getId());
		em.remove(emprestimo);
	}
	
	@Override
	public Emprestimo insere(Emprestimo e) {
		e.setHoraEmprestado(String.valueOf((new SimpleDateFormat("dd/MM - HH:mm").format(new Date()))));
		e.setEmprestado("Emprestado");
		em.persist(e);
		return e;
	}
	
	public Emprestimo receber(Emprestimo e){
		e.setEmprestado("Devolvido");
		e.setHoraDevolucao(String.valueOf((new SimpleDateFormat("dd/MM - HH:mm").format(new Date()))));
		em.merge(e);
		return e;
	}

	@Override
	public Emprestimo altera(Emprestimo e) {
		em.merge(e);
		return e;
	}

	@Override
	public Emprestimo devolve(Emprestimo e) {
		em.merge(e);
		return e;
	}

	@Override
	public Emprestimo buscaPorId(Long id) {
		Emprestimo e = em.find(Emprestimo.class, id);
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emprestimo> buscaTodos() {
		Query q = em.createNamedQuery("busca.todos.emprestimos");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emprestimo> buscaEmprestados() {
		Query q = em.createNamedQuery("busca.emprestados.emprestimos");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Emprestimo> buscaDevolvidos() {
		Query q = em.createNamedQuery("busca.devolvidos.emprestimos");
		return q.getResultList();
	}
	
	

}
