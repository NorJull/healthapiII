package com.vamosaprogramar.umedicalapi.entity;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;

@Entity
@Table(name = "procedimiento_aiepi")
public class ProcedimientoAIEPI {

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

	@Column(name = "nombre_procedimiento")
	private String nombreProcedimiento;

	@Column(name = "ambito_realizacion")
	private String ambitoRealizacion;

	@Column(name = "finalidad")
	private String finalidad;
	
	@Column(name = "persona_que_atiende")
	private String personaQueAtiende;
	
	@Column(name = "codigo_diagnostico_principal")
	private String codigoDiagnosticoPrincipal;
	
	@Column(name = "codigo_diagnostico_relacionado")
	private String codigoDiagnosticoRelacionado;
	
	@Column(name = "codigo_diagnostico_complicacion")
	private String codigoDiagnosticoComplicacion;
	
	@Column(name = "forma_realizacion")
	private String formaRealizacion;
	
	@Column(name = "valor")
	private double valor;
	
	@Column(name = "es_particular")
	private String esParticular;
	
	@Column(name = "contract_id")
	private Integer contractId;	 
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "registro_aiepi_id")
	private RegistroAIEPI registroAIEPI;

	public ProcedimientoAIEPI() {
		
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

	public String getNombreProcedimiento() {
		return nombreProcedimiento;
	}

	public void setNombreProcedimiento(String nombreProcedimiento) {
		this.nombreProcedimiento = nombreProcedimiento;
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

	public String getPersonaQueAtiende() {
		return personaQueAtiende;
	}

	public void setPersonaQueAtiende(String personaQueAtiende) {
		this.personaQueAtiende = personaQueAtiende;
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

	public String getCodigoDiagnosticoComplicacion() {
		return codigoDiagnosticoComplicacion;
	}

	public void setCodigoDiagnosticoComplicacion(String codigoDiagnosticoComplicacion) {
		this.codigoDiagnosticoComplicacion = codigoDiagnosticoComplicacion;
	}

	public String getFormaRealizacion() {
		return formaRealizacion;
	}

	public void setFormaRealizacion(String formaRealizacion) {
		this.formaRealizacion = formaRealizacion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public RegistroAIEPI getRegistroAIEPI() {
		return registroAIEPI;
	}

	public void setRegistroAIEPI(RegistroAIEPI registroAIEPI) {
		this.registroAIEPI = registroAIEPI;
	}

	public String getEsParticular() {
		return esParticular;
	}

	public void setEsParticular(String esParticular) {
		this.esParticular = esParticular;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

		
}
