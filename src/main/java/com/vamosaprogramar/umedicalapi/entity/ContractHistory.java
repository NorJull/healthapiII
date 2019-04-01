package com.vamosaprogramar.umedicalapi.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;


@Entity
@Table(name = "contract_history")
public class ContractHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name ="contract_id")
	private int contractId;
	
	@Column(name ="patient_id")
	private int patientId;

	@Column(name="start_date")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = GeneralConstants.DATE_FORMAT)
	private LocalDate startDate;
	
	
	@Column(name="finish_date")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = GeneralConstants.DATE_FORMAT)
	private LocalDate finishDate;
	
	
	public ContractHistory() {
		
	}

	

	public ContractHistory(int contractId, int patientId, LocalDate startDate, LocalDate finishDate) {

		this.contractId = contractId;
		this.patientId = patientId;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}






	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getContractId() {
		return contractId;
	}


	public void setContractId(int contractId) {
		this.contractId = contractId;
	}


	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
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
	
	
}
