package com.view.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.ejb.intf.EmprestimoSession;
import com.model.ejb.entity.Emprestimo;

@ManagedBean(name = "emprestimoListaBean")
@ViewScoped
public class EmprestimoListaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Emprestimo> emprestimos;
	private int qtdEmprestados;

	@EJB
	private EmprestimoSession emprestimoSession;

	@PostConstruct
	public void init() {
		emprestimos = buscaTodosEmprestimos();
		setQtdEmprestados(emprestimoSession.buscaEmprestados().size());
	}

	// Métodos internos

	private List<Emprestimo> buscaTodosEmprestimos() {
		return emprestimoSession.buscaTodos();
	}

	private List<Emprestimo> buscaEmprestadosEmprestimos() {
		return emprestimoSession.buscaEmprestados();
	}

	// Métodos chamados na página

	public List<Emprestimo> getTodosEmprestimos() {
		return emprestimoSession.buscaTodos();
	}

	public List<Emprestimo> getEmprestadosEmprestimos() {
		return emprestimoSession.buscaEmprestados();
	}
	
	public List<Emprestimo> getDevolvidosEmprestimos(){
		return emprestimoSession.buscaDevolvidos();
	}

	public String removeEmprestimo(Emprestimo emprestimo) {
		emprestimoSession.remove(emprestimo);
		return "lista?faces-redirect=true";
	}

	public String devolveEmprestimo(Emprestimo emprestimo) {
		emprestimoSession.devolve(emprestimo);
		return "lista?faces-redirect=true";
	}

	public int getQtdEmprestados() {
		return qtdEmprestados;
	}

	public void setQtdEmprestados(int qtdEmprestados) {
		this.qtdEmprestados = qtdEmprestados;
	}

}
