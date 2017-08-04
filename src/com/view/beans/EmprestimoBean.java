package com.view.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.ejb.intf.EmprestimoSession;
import com.model.ejb.entity.Emprestimo;

@ManagedBean(name="emprestimoBean")
@ViewScoped
public class EmprestimoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private EmprestimoSession emprestimoSession;
	
	public EmprestimoBean() {
	}
	
	@PostConstruct
	public void init() {
		this.emprestimos = emprestimoSession.buscaTodos();
	}
	
	private List<Emprestimo> emprestimos;
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

}
