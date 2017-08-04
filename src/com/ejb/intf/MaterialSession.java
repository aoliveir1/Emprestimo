package com.ejb.intf;

import java.util.List;

import javax.ejb.Local;

import com.model.ejb.entity.Material;

@Local
public interface MaterialSession {
	
	void remove(Material m);
	Material insere(Material m);
	Material altera(Material m);
	Material buscaPorId(Long id);
	List<Material> buscaTodos();
	List<String> buscaNomes();
}
