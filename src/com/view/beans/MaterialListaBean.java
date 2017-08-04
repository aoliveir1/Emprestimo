package com.view.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.ejb.intf.MaterialSession;
import com.model.ejb.entity.Material;

@ManagedBean(name = "materialListaBean")
@ViewScoped
public class MaterialListaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Material> materiais;
	private List<String> nomes;
	
	@EJB
	private MaterialSession materialSession;

	@PostConstruct
	public void init() {
		setMateriais(buscaTodosMateriais());
		setNomes(buscaNomes());
	}

	// Métodos internos

	private List<Material> buscaTodosMateriais() {
		return materialSession.buscaTodos();
	}
	
	private List<String> buscaNomes(){
		return materialSession.buscaNomes();
	}

	// Métodos chamados na página

	public List<Material> getTodosMateriais() {
		return materialSession.buscaTodos();
	}
	
	public List<String> getNomes(){
		return materialSession.buscaNomes();
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}
	
	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

}
