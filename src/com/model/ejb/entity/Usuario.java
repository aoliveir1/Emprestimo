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
@Table(name = "Usuario")
@SequenceGenerator(name = "Usuario_Sequence", sequenceName = "usuario_seq", allocationSize = 0, initialValue = 1)
@NamedQueries({	@NamedQuery(name = "busca.todos.usuarios", query = "select u from Usuario as u"),
	@NamedQuery(name = "busca.nomes.usuarios", query = "select u.nome from Usuario as u order by u.nome")})
public class Usuario implements Serializable, Comparable<Usuario> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Usuario_Sequence")
	private Long id;

	@Column(name = "nome", length = 60, nullable = true)
	private String nome;
		
	@Column(name = "login", length = 16, nullable = true)
	private String login;

	@Column(name = "senha", length = 16, nullable = true)
	private String senha;
	
	public Usuario() {
	}

	public Usuario(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(Long id, String nome, String login, String senha) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Usuario e) {
		if (this.id > e.id) {
			return -1;
		} else if (this.id < e.id) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
	}

}
