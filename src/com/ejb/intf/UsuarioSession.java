package com.ejb.intf;

import java.util.List;

import javax.ejb.Local;

import com.model.ejb.entity.Usuario;

@Local
public interface UsuarioSession {
	
	void remove(Usuario u);
	Usuario insere(Usuario u);
	Usuario altera(Usuario u);
	Usuario buscaPorId(Long id);
	List<Usuario> buscaTodos();
	List<String> buscaNomes();
}
