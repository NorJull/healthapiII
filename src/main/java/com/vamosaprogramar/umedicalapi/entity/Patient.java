package com.vamosaprogramar.umedicalapi.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;

@Entity
@Table(name = "patient")
public class Patient {

	//ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// Carnet
	@Column(name = "carnet", unique = true)
	private String carnet;

	// Tipo de documento
	@Column(name = "document_type")
	private String documentType;

	// Número de identificación
	@Column(name = "document", unique = true)
	private String document;

	// Primer apellido
	@Column(name = "last_name_1")
	private String lastName1;

	// Segundo apellido
	@Column(name = "last_name_2")
	private String lastName2;

	// Primer nombre
	@Column(name = "name_1")
	private String name1;

	// Segundo nombre
	@Column(name = "name_2")
	private String name2;

	// Fecha de nacimiento
	@Column(name = "birth_date")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate birthDate;

	// Edad
	@Column(name = "age")
	private int age;

	// Sexo
	@Column(name = "gender")
	private String gender;

	// SISBEN
	@Column(name = "sisben", unique = true)
	private String sisben;

	// Nivel de SISBEN
	@Column(name = "sisben_level")
	private String sisbenLevel;

	// BARRIO-------------------

	@Column(name = "neighborhood_number")
	private String neighborhoodNumber;

	@Column(name = "neighborhood")
	private String neighborhood;

	// DEPARTAMENTO-------------
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "departament_id")
	private Departament departament;

	// CIUDAD------------------
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "town_id")
	private Town town;

	// Dirección
	@Column(name = "address")
	private String address;

	// IPS Asignada
	@Column(name = "ips_number")
	private String ipsNumber;

	// Descripción de la IPS
	@Column(name = "ips")
	private String ips;

	// Zona
	@Column(name = "zone")
	private String zone;

	// Fecha de afiliación
	@Column(name = "membership_date")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate membershipDate;

	// Número de telefono
	@Column(name = "phone_number")
	private String phoneNumber;

	// fosyga
	@Column(name = "fosyga", unique = true)
	private String fosyga;

	// Huella
	@Column(name = "fingerprint")
	private String fingerprint;

	// Tipo de población
	@Column(name = "poblation_type")
	private String poblationType;

	// Estado
	@Column(name = "state")
	private String state;

	// Regimen
	@Column(name = "regime")
	private String regime;

	// Tipo de afiliación
	@Column(name = "membership_type")
	private String membershipType;

	// Salario
	@Column(name = "salary")
	private String salary;

	// Categoria
	@Column(name = "category")
	private String category;

	@JsonIgnore
	@ManyToMany(mappedBy = "patients")
	private List<Contract> contracts;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY ,mappedBy="patient",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Appointment> appointments; 
	
	
	public Patient() {

	}

	public Patient(int id, String carnet, String documentType, String document, String lastName1,
			String lastName2, String name1, String name2, LocalDate birthDate, int age, String gender, String sisben,
			String sisbenLevel, String neighborhoodNumber, String neighborhood, Departament departament, Town town,
			String address, String ipsNumber, String ips, String zone, LocalDate membershipDate, String phoneNumber,
			String fosyga, String fingerprint, String poblationType, String state, String regime,
			String membershipType, String salary, String category) {

		this.id = id;
		this.carnet = carnet;
		this.documentType = documentType;
		this.document = document;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.name1 = name1;
		this.name2 = name2;
		this.birthDate = birthDate;
		this.age = age;
		this.gender = gender;
		this.sisben = sisben;
		this.sisbenLevel = sisbenLevel;
		this.neighborhoodNumber = neighborhoodNumber;
		this.neighborhood = neighborhood;
		this.departament = departament;
		this.town = town;
		this.address = address;
		this.ipsNumber = ipsNumber;
		this.ips = ips;
		this.zone = zone;
		this.membershipDate = membershipDate;
		this.phoneNumber = phoneNumber;
		this.fosyga = fosyga;
		this.fingerprint = fingerprint;
		this.poblationType = poblationType;
		this.state = state;
		this.regime = regime;
		this.membershipType = membershipType;
		this.salary = salary;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getLastName1() {
		return lastName1;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSisben() {
		return sisben;
	}

	public void setSisben(String sisben) {
		this.sisben = sisben;
	}

	public String getSisbenLevel() {
		return sisbenLevel;
	}

	public void setSisbenLevel(String sisbenLevel) {
		this.sisbenLevel = sisbenLevel;
	}

	public String getNeighborhoodNumber() {
		return neighborhoodNumber;
	}

	public void setNeighborhoodNumber(String neighborhoodNumber) {
		this.neighborhoodNumber = neighborhoodNumber;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIpsNumber() {
		return ipsNumber;
	}

	public void setIpsNumber(String ipsNumber) {
		this.ipsNumber = ipsNumber;
	}

	public String getIps() {
		return ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public LocalDate getMembershipDate() {
		return membershipDate;
	}

	public void setMembershipDate(LocalDate membershipDate) {
		this.membershipDate = membershipDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFosyga() {
		return fosyga;
	}

	public void setFosyga(String fosyga) {
		this.fosyga = fosyga;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getPoblationType() {
		return poblationType;
	}

	public void setPoblationType(String poblationType) {
		this.poblationType = poblationType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public void addContract(Contract contract) {
		
		if(contracts==null) {
			contracts = new ArrayList<Contract>();
		}
		contracts.add(contract);
	}

	public void addAppointment(Appointment appointment) {
		if(appointments==null) {
			appointments = new ArrayList<>();
		}
		appointments.add(appointment);
		appointment.setPatient(this);
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", carnet=" + carnet + ", documentType=" + documentType + ", document=" + document
				+ ", lastName1=" + lastName1 + ", lastName2=" + lastName2 + ", name1=" + name1 + ", name2=" + name2
				+ ", birthDate=" + birthDate + "]";
	}
	


	
}
