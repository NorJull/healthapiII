package com.vamosaprogramar.umedicalapi.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;
import com.vamosaprogramar.umedicalapi.entity.enumerable.ContractType;

@Entity
@Table(name = "contrato")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "health_entity_id")
	private HealthEntity healthEntity;
	    
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "manual_tarifario_id")
	private ManualTarifario manualTarifario;
	
	@Column(name ="numero_contrato")
	private String numeroContrato;
	
	@Column(name ="tipo")
	private char tipo;
	
	@Column(name ="plan_beneficios")
	private String planBeneficios;
	
	@Column(name ="numero_poliza")
	private String numeroPoliza;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name="fecha_inicial")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate fechaInicial;
	
	
	@Column(name="fecha_final")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate fechaFinal;
	
	@Column(name = "valor")
	private double valor;
	
	
	@Column(name="porcentaje_manual_tarifario")
	private double porcentajeManualTarifario;
	
	
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
        name = "contrato_tipo_procedimeinto", 
        joinColumns = { @JoinColumn(name = "contrato_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "tipo_procedimiento_id") }
    )
	private List<TipoProcedimiento> tiposProcedimientos;
		
	
	
	public Contrato() {
	
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@JsonIgnore
	public HealthEntity getHealthEntity() {
		return healthEntity;
	}

	@JsonProperty
	public void setHealthEntity(HealthEntity healthEntity) {
		this.healthEntity = healthEntity;
	}


	public ManualTarifario getRateManual() {
		return manualTarifario;
	}


	public void setRateManual(ManualTarifario rateManual) {
		this.manualTarifario = rateManual;
	}


	public ManualTarifario getManualTarifario() {
		return manualTarifario;
	}



	public void setManualTarifario(ManualTarifario manualTarifario) {
		this.manualTarifario = manualTarifario;
	}



	public String getNumeroContrato() {
		return numeroContrato;
	}



	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}



	public char getTipo() {
		return tipo;
	}



	public void setTipo(char tipo) {
		this.tipo = tipo;
	}



	public String getPlanBeneficios() {
		return planBeneficios;
	}



	public void setPlanBeneficios(String planBeneficios) {
		this.planBeneficios = planBeneficios;
	}



	public String getNumeroPoliza() {
		return numeroPoliza;
	}



	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public LocalDate getFechaInicial() {
		return fechaInicial;
	}



	public void setFechaInicial(LocalDate fechaInicial) {
		this.fechaInicial = fechaInicial;
	}



	public LocalDate getFechaFinal() {
		return fechaFinal;
	}



	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public double getPorcentajeManualTarifario() {
		return porcentajeManualTarifario;
	}



	public void setPorcentajeManualTarifario(double porcentajeManualTarifario) {
		this.porcentajeManualTarifario = porcentajeManualTarifario;
	}



	public List<TipoProcedimiento> getTiposProcedimientos() {
		return tiposProcedimientos;
	}



	public void setTiposProcedimientos(List<TipoProcedimiento> tiposProcedimientos) {
		this.tiposProcedimientos = tiposProcedimientos;
	}



	public List<TipoProcedimiento> getProcedureTypes() {
		return tiposProcedimientos;
	}


	public void setProcedureTypes(List<TipoProcedimiento> procedureTypes) {
		this.tiposProcedimientos = procedureTypes;
	}
	
	
	public void addProcedureType(TipoProcedimiento procedureType) {
		
		if(tiposProcedimientos==null) {
			tiposProcedimientos = new ArrayList<TipoProcedimiento>();
		}
		
		tiposProcedimientos.add(procedureType);
		
		procedureType.getContractos().add(this);
		
	}

	public void removeProcedureType(TipoProcedimiento procedureType) {
		
		if(tiposProcedimientos==null) {
			tiposProcedimientos = new ArrayList<TipoProcedimiento>();
		}
		if(tiposProcedimientos.remove(procedureType)) {
			
			procedureType.getContractos().remove(this);
		}
		
	}
	
	
	
}
