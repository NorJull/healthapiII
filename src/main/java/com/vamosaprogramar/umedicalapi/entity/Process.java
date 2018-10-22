package com.vamosaprogramar.umedicalapi.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="process")
public class Process {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private char status;
	
	
	@Column(name="start_date")
	@Convert(converter = LocalDateTimeConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime startDateTime;
	
	
	@Column(name="finish_date")
	@Convert(converter = LocalDateTimeConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime finishDateTime;

	@Column(name="total_rows")
	private int totalRows;
	
	@Column(name="current_rows")
	private int currentRow;
	
	@Column(name="percent")
	private double percent;
	
	@Column(name="log", columnDefinition="text")
	private String log;
	
	
	public Process() {
		
	}



	public Process(int id, String description, char status, LocalDateTime startDateTime, LocalDateTime finishDateTime,
			int totalRows, int currentRow, double percent, String log) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.startDateTime = startDateTime;
		this.finishDateTime = finishDateTime;
		this.totalRows = totalRows;
		this.currentRow = currentRow;
		this.percent = percent;
		this.log = log;
	}



	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}



	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}



	public LocalDateTime getFinishDateTime() {
		return finishDateTime;
	}



	public void setFinishDateTime(LocalDateTime finishDateTime) {
		this.finishDateTime = finishDateTime;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public char getStatus() {
		return status;
	}


	public void setStatus(char status) {
		this.status = status;
	}



	public int getTotalRows() {
		return totalRows;
	}


	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}




	public int getCurrentRow() {
		return currentRow;
	}



	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}



	public double getPercent() {
		return percent;
	}


	public void setPercent(double percent) {
		this.percent = percent;
	}


	public String getLog() {
		return log;
	}


	public void setLog(String log) {
		this.log = log;
	}
	
}
