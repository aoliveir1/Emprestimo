package com.ejb.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.intf.MaterialSession;
import com.model.ejb.entity.Material;

@Stateless
public class MaterialSessionBean implements MaterialSession {

	@PersistenceContext(unitName = "C8")
	private EntityManager em;

	@Override
	public void remove(Material m) {
		Material material = em.find(Material.class, m.getId());
		em.remove(material);
	}
	
	@Override
	public Material insere(Material m) {
		em.persist(m);
		return m;
	}
	
	@Override
	public Material altera(Material m) {
		em.merge(m);
		return m;
	}

	@Override
	public Material buscaPorId(Long id) {
		Material m = em.find(Material.class, id);
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> buscaTodos() {
		Query q = em.createNamedQuery("busca.todos.materiais");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<String> buscaNomes(){
		Query q = em.createNamedQuery("busca.nomes.materiais");
		return q.getResultList();
	}

}
