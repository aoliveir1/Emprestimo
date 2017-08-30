package com.view.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import com.ejb.intf.EmprestimoSession;
import com.model.ejb.entity.Emprestimo;

@ManagedBean(name = "emprestimoFormBean")
@ViewScoped
public class EmprestimoFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	EmprestimoSession emprestimoSession;
	
	private Emprestimo emprestimo;
	
	public EmprestimoFormBean() {
	}
	
	@PostConstruct
	public void init() {
		this.emprestimo = new Emprestimo();
	}

	// Getters e Setters para as propriedades

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	

	
	// Métodos chamados na página listaCursos

	public void buscaEmprestimo(ActionEvent actionEvent) {
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
				this.emprestimo = this.buscaPorId(id);
			} else {
				this.emprestimo = new Emprestimo();
			}
		} catch (Exception e) {
			this.emprestimo = new Emprestimo();
		}
	}
	
	public void limpaEmprestimo(ActionEvent actionEvent) {
		this.init();
	}

	// Métodos chamados na página formCursos

	public String inserir() {
		emprestimoSession.insere(emprestimo);
		return "lista?faces-redirect=true";
	}
	
	public String alterar() {
		emprestimoSession.altera(emprestimo);
		return "lista?faces-redirect=true";
	}
	
	public String excluir() {
		emprestimoSession.remove(emprestimo);
		return "lista?faces-redirect=true";
	}

	public String limpar() {
		init();
		return "mantem?faces-redirect=true";
	}
	
	public String receber(){
		emprestimoSession.receber(emprestimo);
		return "devolvidos?faces-redirect=true";
	}

	public String novo() {
		return "lista?faces-redirect=true";
	}

	public boolean isInclusao() {
		return (this.emprestimo == null ? true : (this.emprestimo.getId() == null));
	}
	
	// Metodos internos
	private Emprestimo buscaPorId(Long id) {
		return emprestimoSession.buscaPorId(id);
	}
}
