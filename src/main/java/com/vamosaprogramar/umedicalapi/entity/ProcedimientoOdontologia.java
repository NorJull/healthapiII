package com.vamosaprogramar.umedicalapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;

@Entity
@Table(name = "procedimiento_odontologia")
public class ProcedimientoOdontologia {

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
	@JoinColumn(name = "registro_odontologia_id")
	private RegistroOdontologia registroOdontologia;

	public ProcedimientoOdontologia() {
		
	}

	public ProcedimientoOdontologia(ProcedimientoOrdenadoOdontologia procedimientoOrdenadoOdontologia) {
		this.fecha = LocalDate.now();
		this.numeroAutorizacion = procedimientoOrdenadoOdontologia.getNumeroAutorizacion();
		this.cup = procedimientoOrdenadoOdontologia.getCup();
		this.ambitoRealizacion = procedimientoOrdenadoOdontologia.getAmbitoRealizacion();
		this.finalidad = procedimientoOrdenadoOdontologia.getFinalidad();
		this.codigoDiagnosticoPrincipal = procedimientoOrdenadoOdontologia.getCodigoDiagnosticoPrincipal();
		this.codigoDiagnosticoRelacionado = procedimientoOrdenadoOdontologia.getCodigoDiagnosticoRelacionado();
		this.contractId = procedimientoOrdenadoOdontologia.getContractId();
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

	public RegistroOdontologia getRegistroOdontologia() {
		return registroOdontologia;
	}

	public void setRegistroOdontologia(RegistroOdontologia registroOdontologia) {
		this.registroOdontologia = registroOdontologia;
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
