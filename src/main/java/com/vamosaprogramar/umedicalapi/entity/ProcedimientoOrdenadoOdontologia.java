package com.vamosaprogramar.umedicalapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;

import javax.persistence.*;
import java.time.LocalDate;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;

@Entity
@Table(name = "procedimiento_ordenado_odontologia")
public class ProcedimientoOrdenadoOdontologia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name="fecha")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate fecha;

	@Column(name = "numero_autorizacion")
	private String numeroAutorizacion;

	@Column(name = "cup")
	private String cup;

	@Column(name = "ambito_realizacion")
	private String ambitoRealizacion;

	@Column(name = "finalidad")
	private String finalidad;

	@Column(name = "codigo_diagnostico_principal")
	private String codigoDiagnosticoPrincipal;

	@Column(name = "codigo_diagnostico_relacionado")
	private String codigoDiagnosticoRelacionado;

	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "registro_odontologia_id")
	private RegistroOdontologia registroOdontologia;

	@Column(name = "contract_id")
	private Integer contractId;	 
	
	@Column(name = "fue_ejecutado")
	private String fueEjecutado;
	
	@Column(name = "url_resultados")
	private String urlResultados;
	
	public ProcedimientoOrdenadoOdontologia() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public String getCup() {
		return cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}

	public String getAmbitoRealizacion() {
		return ambitoRealizacion;
	}

	public void setAmbitoRealizacion(String ambitoRealizacion) {
		this.ambitoRealizacion = ambitoRealizacion;
	}

	public String getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(String finalidad) {
		this.finalidad = finalidad;
	}

	public String getCodigoDiagnosticoPrincipal() {
		return codigoDiagnosticoPrincipal;
	}

	public void setCodigoDiagnosticoPrincipal(String codigoDiagnosticoPrincipal) {
		this.codigoDiagnosticoPrincipal = codigoDiagnosticoPrincipal;
	}

	public String getCodigoDiagnosticoRelacionado() {
		return codigoDiagnosticoRelacionado;
	}

	public void setCodigoDiagnosticoRelacionado(String codigoDiagnosticoRelacionado) {
		this.codigoDiagnosticoRelacionado = codigoDiagnosticoRelacionado;
	}

	public RegistroOdontologia getRegistroOdontologia() {
		return registroOdontologia;
	}

	public void setRegistroOdontologia(RegistroOdontologia registroOdontologia) {
		this.registroOdontologia = registroOdontologia;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public String getFueEjecutado() {
		return fueEjecutado;
	}

	public void setFueEjecutado(String fueEjecutado) {
		this.fueEjecutado = fueEjecutado;
	}

	public String getUrlResultados() {
		return urlResultados;
	}

	public void setUrlResultados(String urlResultados) {
		this.urlResultados = urlResultados;
	}
	
}
