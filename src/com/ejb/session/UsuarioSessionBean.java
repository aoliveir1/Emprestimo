package com.ejb.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.intf.UsuarioSession;
import com.model.ejb.entity.Usuario;

@Stateless
public class UsuarioSessionBean implements UsuarioSession {

	@PersistenceContext(unitName = "C8")
	private EntityManager em;

	@Override
	public void remove(Usuario e) {
		Usuario usuario = em.find(Usuario.class, e.getId());
		em.remove(usuario);
	}
	
	@Override
	public Usuario insere(Usuario u) {
		em.persist(u);
		return u;
	}
	
	@Override
	public Usuario altera(Usuario u) {
		em.merge(u);
		return u;
	}

	@Override
	public Usuario buscaPorId(Long id) {
		Usuario u = em.find(Usuario.class, id);
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscaTodos() {
		Query q = em.createNamedQuery("busca.todos.usuarios");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<String> buscaNomes(){
		Query q = em.createNamedQuery("busca.nomes.usuarios");
		return q.getResultList();
	}

}
