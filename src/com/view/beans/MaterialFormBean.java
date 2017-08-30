package com.view.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import com.ejb.intf.MaterialSession;
import com.model.ejb.entity.Material;

@ManagedBean(name = "materialFormBean")
@ViewScoped
public class MaterialFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	MaterialSession materialSession;
	
	private Material material;

	public MaterialFormBean() {
	}
	
	@PostConstruct
	public void init() {
		this.material = new Material();
	}

	// Getters e Setters para as propriedades

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	// Métodos chamados na página listaMateriais
	
	public void buscaMaterial(ActionEvent actionEvent) {
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
				this.material = this.buscaPorId(id);
			} else {
				this.material = new Material();
			}
		} catch (Exception e) {
			this.material = new Material();
		}
	}
	
	public void limpaUsuario(ActionEvent actionEvent) {
		this.init();
	}

	// Métodos chamados na página formUsu�rios

	public String inserir() {
		materialSession.insere(material);
		return "";
	}
	
	public String alterar() {
		materialSession.altera(material);
		return "lista?faces-redirect=true";
	}
	
	public String excluir() {
		materialSession.remove(material);
		return "ferramentas?faces-redirect=true";
	}
	
	public String limpar() {
		init();
		return "mantem?faces-redirect=true";
	}
	
	public String novo() {
		return "lista?faces-redirect=true";
	}

	public boolean isInclusao() {
		return (this.material == null ? true : (this.material.getId() == null));
	}
	
	// Metodos internos
	private Material buscaPorId(Long id) {
		return materialSession.buscaPorId(id);
	}
}
