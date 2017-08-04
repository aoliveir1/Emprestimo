package com.ejb.intf;

import java.util.List;

import javax.ejb.Local;

import com.model.ejb.entity.Emprestimo;

@Local
public interface EmprestimoSession {
	
	void remove(Emprestimo e);
	Emprestimo insere(Emprestimo e);
	Emprestimo altera(Emprestimo e);
	Emprestimo devolve(Emprestimo e);
	Emprestimo buscaPorId(Long id);
	List<Emprestimo> buscaTodos();
	List<Emprestimo> buscaEmprestados();
	Emprestimo receber(Emprestimo emprestimo);
	List<Emprestimo> buscaDevolvidos();

}
