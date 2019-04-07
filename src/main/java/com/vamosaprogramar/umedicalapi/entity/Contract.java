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
@Table(name = "contract")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "health_entity_id")
	private HealthEntity healthEntity;
	
    
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "rate_manual_id")
	private RateManual rateManual;
	
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
        name = "contract_procedureType", 
        joinColumns = { @JoinColumn(name = "contract_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "procedure_type_id") }
    )
	private List<ProcedureType> procedureTypes;
		
	@Column(name = "description")
	private String description;
	
	@Column(name="manual_percent")
	private double manualPercent;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "contract_type")
	private ContractType contractType;
	
	@Column(name="start_date")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate startDate;
	
	
	@Column(name="finish_date")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate finishDate;
	
	@Column(name = "value")
	private double value;

	
	public Contract() {
	
	}


	public Contract(int id, HealthEntity healthEntity, ContractType contractType, double value) {
		this.id = id;
		this.healthEntity = healthEntity;
		this.contractType = contractType;
		this.value = value;
	}

	
	public Contract(int id, HealthEntity healthEntity, String description, double manualPercent,
			ContractType contractType, LocalDate startDate, LocalDate finishDate, double value) {

		this.id = id;
		this.healthEntity = healthEntity;
		this.description = description;
		this.manualPercent = manualPercent;
		this.contractType = contractType;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.value = value;
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


	public ContractType getContractType() {
		return contractType;
	}


	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


	public RateManual getRateManual() {
		return rateManual;
	}


	public void setRateManual(RateManual rateManual) {
		this.rateManual = rateManual;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getFinishDate() {
		return finishDate;
	}


	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getManualPercent() {
		return manualPercent;
	}


	public void setManualPercent(double manualPercent) {
		this.manualPercent = manualPercent;
	}


	public List<ProcedureType> getProcedureTypes() {
		return procedureTypes;
	}


	public void setProcedureTypes(List<ProcedureType> procedureTypes) {
		this.procedureTypes = procedureTypes;
	}
	
	
	public void addProcedureType(ProcedureType procedureType) {
		
		if(procedureTypes==null) {
			procedureTypes = new ArrayList<ProcedureType>();
		}
		
		procedureTypes.add(procedureType);
		
		procedureType.getContracts().add(this);
		
	}

	public void removeProcedureType(ProcedureType procedureType) {
		
		if(procedureTypes==null) {
			procedureTypes = new ArrayList<ProcedureType>();
		}
		if(procedureTypes.remove(procedureType)) {
			
			procedureType.getContracts().remove(this);
		}
		
	}
	
	@Override
	public String toString() {
		return "Contract [id=" + id + ", healthEntity=" + healthEntity + ", contractType=" + contractType + ", value="
				+ value + "]";
	}
	
	
	
	
	
}
