package com.view.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.ejb.intf.UsuarioSession;
import com.model.ejb.entity.Usuario;

@ManagedBean(name = "usuarioListaBean")
@ViewScoped
public class UsuarioListaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;
	private List<String> nomes;

	@EJB
	private UsuarioSession usuarioSession;

	@PostConstruct
	public void init() {
		setUsuarios(buscaTodosUsuarios());
		setNomes(buscaNomes());
	}

	// Métodos internos

	private List<Usuario> buscaTodosUsuarios() {
		return usuarioSession.buscaTodos();
	}
	
	private List<String> buscaNomes(){
		return usuarioSession.buscaNomes();
	}

	// Métodos chamados na página

	public List<Usuario> getTodosUsuarios() {
		return usuarioSession.buscaTodos();
	}

	public List<String> getNomes(){
		return usuarioSession.buscaNomes();
	}
	
	public String removeUsuario(Usuario usuario) {
		usuarioSession.remove(usuario);
		return "lista?faces-redirect=true";
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

}
