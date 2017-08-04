package com.model.ejb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Emprestimo")
@SequenceGenerator(name = "Emprestimo_Sequence", sequenceName = "emprestimo_seq", allocationSize = 0, initialValue = 1)
@NamedQueries({
		@NamedQuery(name = "busca.emprestados.emprestimos", query = "select e from Emprestimo as e where emprestado like 'Emprestado' order by id desc"),
		@NamedQuery(name = "busca.devolvidos.emprestimos", query = "select e from Emprestimo as e where emprestado like 'Devolvido' order by horaDevolucao desc"),
		@NamedQuery(name = "busca.todos.emprestimos", query = "select e from Emprestimo as e order by horaDevolucao desc")})
public class Emprestimo implements Serializable, Comparable<Emprestimo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Emprestimo_Sequence")
	private Long id;

	@Column(name = "nome", length = 60, nullable = true)
	private String nome;

	@Column(name = "material", length = 120, nullable = true)
	private String material;
	
	@Column(name = "sala", length = 16, nullable = true)
	private String sala;

	@Column(name = "quemEmprestou", length = 16, nullable = true)
	private String quemEmprestou;

	@Column(name = "horaEmprestado", length = 13, nullable = true)
	private String horaEmprestado;

	@Column(name = "emprestado", length = 10, nullable = true)
	private String emprestado;

	@Column(name = "horaDevolucao", length = 13, nullable = true)
	private String horaDevolucao;

	@Column(name = "quemRecebeu", length = 16, nullable = true)
	private String quemRecebeu;
	
	public Emprestimo() {
	}

	public Emprestimo(String nome, String material, String sala, String quemEmprestou, String horaEmprestado,
			String emprestado) {
		this.nome = nome;
		this.material = material;
		this.sala = sala;
		this.quemEmprestou = quemEmprestou;
		this.horaEmprestado = horaEmprestado;
		this.emprestado = emprestado;
	}

	public Emprestimo(Long id, String nome, String material, String sala, String quemEmprestou, String horaEmprestado,
			String emprestado) {
		this.id = id;
		this.nome = nome;
		this.material = material;
		this.sala = sala;
		this.quemEmprestou = quemEmprestou;
		this.horaEmprestado = horaEmprestado;
		this.emprestado = emprestado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMaterial() {
		return material;
	}
	
	public void setMaterial (String material) {
		this.material = material;
	}
	
	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getQuemEmprestou() {
		return quemEmprestou;
	}

	public void setQuemEmprestou(String quemEmprestou) {
		this.quemEmprestou = quemEmprestou;
	}

	public String getHoraEmprestado() {
		return horaEmprestado;
	}

	public void setHoraEmprestado(String horaEmprestado) {
		this.horaEmprestado = horaEmprestado;
	}

	public String getEmprestado() {
		return emprestado;
	}

	public void setEmprestado(String emprestado) {
		this.emprestado = emprestado;
	}

	public String getHoraDevolucao() {
		return horaDevolucao;
	}

	public void setHoraDevolucao(String horaDevolucao) {
		this.horaDevolucao = horaDevolucao;
	}

	public String getQuemRecebeu() {
		return quemRecebeu;
	}

	public void setQuemRecebeu(String quemRecebeu) {
		this.quemRecebeu = quemRecebeu;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", material=" + material + ", sala=" + sala + ", quem emprestou= " + quemEmprestou
				+ ", hora emprestimo=" + horaEmprestado + ", hora devolução=" + horaDevolucao + ", quem recebeu= "
				+ quemRecebeu + "]";
	}

	public String exportCsv() {
		return nome + "," + material + "," + sala + "," + quemEmprestou + "," + horaEmprestado
				+ "," + horaDevolucao + "," + quemRecebeu + "\n";
	}

	@Override
	public int compareTo(Emprestimo e) {
		if (this.id > e.id) {
			return -1;
		} else if (this.id < e.id) {
			return 1;
		}
		return 0;
	}

}
