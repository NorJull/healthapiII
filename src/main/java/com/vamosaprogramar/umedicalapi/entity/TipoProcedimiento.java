package com.vamosaprogramar.umedicalapi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tipo_procedimiento")
public class TipoProcedimiento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cup", unique = true)
	private String cup;
	
	@Column(name = "codigo_concepto")
	private String codigoConcepto;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "genero")
	private String genero;
			
	@JsonIgnore
	@ManyToMany(mappedBy = "tiposProcedimientos")
	private List<Especialidad> especialidades;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "tiposProcedimientos")
	private List<Contrato> contractos;

	
	public TipoProcedimiento() {
		
	}
	
	
	public TipoProcedimiento(String cup, String codigoConcepto, String descripcion, String genero) {
		this.cup = cup;
		this.codigoConcepto = codigoConcepto;
		this.descripcion = descripcion;
		this.genero = genero;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCup() {
		return cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}

	public String getCodigoConcepto() {
		return codigoConcepto;
	}

	public void setCodigoConcepto(String codigoConcepto) {
		this.codigoConcepto = codigoConcepto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Contrato> getContractos() {
		if(contractos== null) {
			contractos = new ArrayList<Contrato>();
		}
		
		return contractos;
	}

	public void setContractos(List<Contrato> contracts) {
		this.contractos = contracts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cup == null) ? 0 : cup.hashCode());
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
		TipoProcedimiento other = (TipoProcedimiento) obj;
		if (cup == null) {
			if (other.cup != null)
				return false;
		} else if (!cup.equals(other.cup))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ProcedureType [id=" + id + ", cup=" + cup + ", description=" + descripcion + "]";
	}
	
}
