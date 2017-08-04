package com.view.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import com.ejb.intf.UsuarioSession;
import com.model.ejb.entity.Usuario;

@ManagedBean(name = "usuarioFormBean")
@ViewScoped
public class UsuarioFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	UsuarioSession usuarioSession;
	
	private Usuario usuario;

	public UsuarioFormBean() {
	}
	
	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
	}

	// Getters e Setters para as propriedades

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	// Métodos chamados na página listaUsuarios
	
	public void buscaUsuario(ActionEvent actionEvent) {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			String sId = (String) fc.getExternalContext()
					.getRequestParameterMap().get("id");
			if (sId != null) {
				Long id = -1l;
				try {
					id = Long.parseLong(sId);
				} catch (NumberFormatException nfe) {

				}
				this.usuario = this.buscaPorId(id);
			} else {
				this.usuario = new Usuario();
			}
		} catch (Exception e) {
			this.usuario = new Usuario();
		}
	}
	
	public void limpaUsuario(ActionEvent actionEvent) {
		this.init();
	}

	// Métodos chamados na página formUsu�rios

	public String inserir() {
		usuarioSession.insere(usuario);
		return "ferramentas?faces-redirect=true";
	}
	
	public String alterar() {
		usuarioSession.altera(usuario);
		return "lista?faces-redirect=true";
	}
	
	public String excluir() {
		usuarioSession.remove(usuario);
		return "lista?faces-redirect=true";
	}

	public String limpar() {
		init();
		return "mantem?faces-redirect=true";
	}
	
	public String novo() {
		return "lista?faces-redirect=true";
	}

	public boolean isInclusao() {
		return (this.usuario == null ? true : (this.usuario.getId() == null));
	}
	
	// Metodos internos
	private Usuario buscaPorId(Long id) {
		return usuarioSession.buscaPorId(id);
	}
}
