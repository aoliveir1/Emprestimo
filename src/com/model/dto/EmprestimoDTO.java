package com.model.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "emprestimo")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EmprestimoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute
	private Long id;	
	
	@XmlAttribute
	private String nome;
	
	@XmlAttribute
	private String material;
	
	@XmlAttribute
	private String sala;
	
	@XmlAttribute
	private String emprestado;
	
	public EmprestimoDTO() {
		super();
	}

	public EmprestimoDTO(Long id, String nome, String material, String sala, String emprestado) {
		super();
		this.id = id;
		this.nome = nome;
		this.material = material;
		this.sala = sala;
		this.emprestado = "Emprestado";
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

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getEmprestado() {
		return emprestado;
	}

	public void setEmprestado(String emprestado) {
		this.emprestado = emprestado;
	}

}
