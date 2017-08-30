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
@Table(name = "Material")
@SequenceGenerator(name = "Material_Sequence", sequenceName = "material_seq", allocationSize = 0, initialValue = 1)
@NamedQueries({	
	@NamedQuery(name = "busca.todos.materiais", query = "select m from Material as m order by m.material"),
	@NamedQuery(name = "busca.nomes.materiais", query = "select m.material from Material as m order by m.material")
	})
public class Material implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Material_Sequence")
	private Long id;

	@Column(name = "material", length = 50, nullable = true)
	private String material;
	
	@Column(name = "tipo", length = 50, nullable = true)
	private String tipo;
	
	public Material(){
		
	}

	public Material(String material, String tipo) {
		super();
		this.material = material;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTipo() {
		return tipo;
	}

	public void setNome(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Material other = (Material) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", material=" + material + ", tipo=" + tipo + "]";
	}
	
}
