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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "especialidad")
public class Especialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "nombre")
	private String nombre;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "tipo_procedimiento_manual_tarifario", joinColumns = {
			@JoinColumn(name = "especialidad_id") }, inverseJoinColumns = {
					@JoinColumn(name = "procedimiento_tipo_id") })
	private List<TipoProcedimiento> tiposProcedimientos;

	@JsonIgnore
	@ManyToMany(mappedBy = "specialities")
	private List<ApplicationUser> usuarios;

	@JsonIgnore
	@OneToMany(mappedBy = "speciality", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Schedule> horarios;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Appointment> citas;

	public Especialidad() {

	}

	public Especialidad(int id, String descripcion) {

		this.id = id;
		this.descripcion = descripcion;
	}

	public Especialidad(int id, String descripcion, String nombre) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<TipoProcedimiento> getTiposProcedimientos() {
		return tiposProcedimientos;
	}

	public void setTiposProcedimientos(List<TipoProcedimiento> tiposProcedimientos) {
		this.tiposProcedimientos = tiposProcedimientos;
	}

	public List<ApplicationUser> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<ApplicationUser> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Schedule> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Schedule> horarios) {
		this.horarios = horarios;
	}

	public List<Appointment> getCitas() {
		return citas;
	}

	public void setCitas(List<Appointment> citas) {
		this.citas = citas;
	}

	public void addUser(ApplicationUser user) {

		if (usuarios == null) {
			usuarios = new ArrayList<ApplicationUser>();
		}

		usuarios.add(user);

	}

	public void addProcedureType(TipoProcedimiento procedureType) {

		if (tiposProcedimientos == null) {
			tiposProcedimientos = new ArrayList<TipoProcedimiento>();
		}

		tiposProcedimientos.add(procedureType);

		procedureType.getEspecialidades().add(this);

	}

	public void removeProcedureType(TipoProcedimiento procedureType) {

		if (tiposProcedimientos == null) {
			tiposProcedimientos = new ArrayList<TipoProcedimiento>();
		}
		if (tiposProcedimientos.remove(procedureType)) {

			procedureType.getEspecialidades().remove(this);
		}

	}

	public void addAppointment(Appointment appointment) {
		if (citas == null) {
			citas = new ArrayList<>();
		}
		citas.add(appointment);
		appointment.setSpeciality(this);
	}

}
