package com.vamosaprogramar.umedicalapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medical_record")
public class MedicalRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "patient_id")
	private int patientId;

	@Column(name = "patient_document_type")
	private String patientDocumentType;

	@Column(name = "patient_document")
	private String patientDocument;

	@Column(name = "patient_name_1")
	private String patientName1;

	@Column(name = "patient_name_2")
	private String patientName2;

	@Column(name = "patient_last_name_1")
	private String patientLastName1;

	@Column(name = "patient_last_name_2")
	private String patientLastName2;

	@Column(name = "patient_birthdate")
	private String patientBirthDate;

	@Column(name = "patient_age")
	private String patientAge;

	@Column(name = "patient_gender")
	private String patientGender;

	@Column(name = "patient_departament")
	private String patientDepartament;

	@Column(name = "patient_town")
	private String patientTown;

	@Column(name = "patient_neighborhood")
	private String patientNeighborhood;

	@Column(name = "patient_address")
	private String patientAddress;

	@Column(name = "patient_phone_number")
	private String patientPhoneNumber;

	@Column(name = "patient_regime")
	private String patientRegime;

	@Column(name = "patient_entity")
	private String patientEntity;

	@Column(name = "attendant_name")
	private String attendantName;

	@Column(name = "attendant_phone_number")
	private String attendantPhoneNumber;

	@Column(name = "purpouse")
	private String purpouse;

	@Column(name = "diagnostic_type")
	private String diagnosticType;

	@Column(name = "medical_consultation_type")
	private String medicalConsultationType;

	@Column(name = "external_cause")
	private String externalCause;

	@Column(name = "consultation_reason")
	private String consultationReason;

	@Column(name = "systems_review")
	private String systemsReview;

	@Column(name = "personal_history")
	private String personalHistory;

	@Column(name = "allergic_history")
	private String allergicHistory;

	@Column(name = "family_history")
	private String familyHistory;

	@Column(name = "surgical_history")
	private String surgicalHistory;

	@Column(name = "obstetric_history")
	private String obstetricHistory;

	@Column(name = "heart_rate")
	private String heartRate;

	@Column(name = "breath_rate")
	private String breathRate;

	@Column(name = "systolic_tension")
	private String systolicTension;

	@Column(name = "diastolic_tension")
	private String diastolicTension;

	@Column(name = "body_temp")
	private String bodyTemp;

	@Column(name = "size")
	private String size;

	@Column(name = "weight")
	private String weight;

	@Column(name = "waist")
	private String waist;

	@Column(name = "hip")
	private String hip;

	@Column(name = "bmi")
	private String bmi;

	@Column(name = "arrival_appearance")
	private String arrivalAppearance;

	@Column(name = "skull_face_neck")
	private String skullFaceNeck;

	@Column(name = "chest")
	private String chest;

	@Column(name = "abdomen")
	private String abdomen;

	@Column(name = "skin_faneras")
	private String skinFaneras;

	@Column(name = "urinary_genital")
	private String urinaryGenital;

	@Column(name = "extremities")
	private String extremities;

	@Column(name = "central_nervous_system")
	private String centralNervousSystem;

	@Column(name = "affected_system")
	private String affectedSystem;

	@Column(name = "plan")
	private String plan;

	@Column(name = "recommendations")
	private String recommendations;

	@Column(name = "observations")
	private String observations;

	public MedicalRecord() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientDocumentType() {
		return patientDocumentType;
	}

	public void setPatientDocumentType(String patientDocumentType) {
		this.patientDocumentType = patientDocumentType;
	}

	public String getPatientDocument() {
		return patientDocument;
	}

	public void setPatientDocument(String patientDocument) {
		this.patientDocument = patientDocument;
	}

	public String getPatientName1() {
		return patientName1;
	}

	public void setPatientName1(String patientName1) {
		this.patientName1 = patientName1;
	}

	public String getPatientName2() {
		return patientName2;
	}

	public void setPatientName2(String patientName2) {
		this.patientName2 = patientName2;
	}

	public String getPatientLastName1() {
		return patientLastName1;
	}

	public void setPatientLastName1(String patientLastName1) {
		this.patientLastName1 = patientLastName1;
	}

	public String getPatientLastName2() {
		return patientLastName2;
	}

	public void setPatientLastName2(String patientLastName2) {
		this.patientLastName2 = patientLastName2;
	}

	public String getPatientBirthDate() {
		return patientBirthDate;
	}

	public void setPatientBirthDate(String patientBirthDate) {
		this.patientBirthDate = patientBirthDate;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientDepartament() {
		return patientDepartament;
	}

	public void setPatientDepartament(String patientDepartament) {
		this.patientDepartament = patientDepartament;
	}

	public String getPatientTown() {
		return patientTown;
	}

	public void setPatientTown(String patientTown) {
		this.patientTown = patientTown;
	}

	public String getPatientNeighborhood() {
		return patientNeighborhood;
	}

	public void setPatientNeighborhood(String patientNeighborhood) {
		this.patientNeighborhood = patientNeighborhood;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}

	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}

	public String getPatientRegime() {
		return patientRegime;
	}

	public void setPatientRegime(String patientRegime) {
		this.patientRegime = patientRegime;
	}

	public String getPatientEntity() {
		return patientEntity;
	}

	public void setPatientEntity(String patientEntity) {
		this.patientEntity = patientEntity;
	}

	public String getAttendantName() {
		return attendantName;
	}

	public void setAttendantName(String attendantName) {
		this.attendantName = attendantName;
	}

	public String getAttendantPhoneNumber() {
		return attendantPhoneNumber;
	}

	public void setAttendantPhoneNumber(String attendantPhoneNumber) {
		this.attendantPhoneNumber = attendantPhoneNumber;
	}

	public String getPurpouse() {
		return purpouse;
	}

	public void setPurpouse(String purpouse) {
		this.purpouse = purpouse;
	}

	public String getDiagnosticType() {
		return diagnosticType;
	}

	public void setDiagnosticType(String diagnosticType) {
		this.diagnosticType = diagnosticType;
	}

	public String getMedicalConsultationType() {
		return medicalConsultationType;
	}

	public void setMedicalConsultationType(String medicalConsultationType) {
		this.medicalConsultationType = medicalConsultationType;
	}

	public String getExternalCause() {
		return externalCause;
	}

	public void setExternalCause(String externalCause) {
		this.externalCause = externalCause;
	}

	public String getConsultationReason() {
		return consultationReason;
	}

	public void setConsultationReason(String consultationReason) {
		this.consultationReason = consultationReason;
	}

	public String getSystemsReview() {
		return systemsReview;
	}

	public void setSystemsReview(String systemsReview) {
		this.systemsReview = systemsReview;
	}

	public String getPersonalHistory() {
		return personalHistory;
	}

	public void setPersonalHistory(String personalHistory) {
		this.personalHistory = personalHistory;
	}

	public String getAllergicHistory() {
		return allergicHistory;
	}

	public void setAllergicHistory(String allergicHistory) {
		this.allergicHistory = allergicHistory;
	}

	public String getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}

	public String getSurgicalHistory() {
		return surgicalHistory;
	}

	public void setSurgicalHistory(String surgicalHistory) {
		this.surgicalHistory = surgicalHistory;
	}

	public String getObstetricHistory() {
		return obstetricHistory;
	}

	public void setObstetricHistory(String obstetricHistory) {
		this.obstetricHistory = obstetricHistory;
	}

	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getBreathRate() {
		return breathRate;
	}

	public void setBreathRate(String breathRate) {
		this.breathRate = breathRate;
	}

	public String getSystolicTension() {
		return systolicTension;
	}

	public void setSystolicTension(String systolicTension) {
		this.systolicTension = systolicTension;
	}

	public String getDiastolicTension() {
		return diastolicTension;
	}

	public void setDiastolicTension(String diastolicTension) {
		this.diastolicTension = diastolicTension;
	}

	public String getBodyTemp() {
		return bodyTemp;
	}

	public void setBodyTemp(String bodyTemp) {
		this.bodyTemp = bodyTemp;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWaist() {
		return waist;
	}

	public void setWaist(String waist) {
		this.waist = waist;
	}

	public String getHip() {
		return hip;
	}

	public void setHip(String hip) {
		this.hip = hip;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getArrivalAppearance() {
		return arrivalAppearance;
	}

	public void setArrivalAppearance(String arrivalAppearance) {
		this.arrivalAppearance = arrivalAppearance;
	}

	public String getSkullFaceNeck() {
		return skullFaceNeck;
	}

	public void setSkullFaceNeck(String skullFaceNeck) {
		this.skullFaceNeck = skullFaceNeck;
	}

	public String getChest() {
		return chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}

	public String getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}

	public String getSkinFaneras() {
		return skinFaneras;
	}

	public void setSkinFaneras(String skinFaneras) {
		this.skinFaneras = skinFaneras;
	}

	public String getUrinaryGenital() {
		return urinaryGenital;
	}

	public void setUrinaryGenital(String urinaryGenital) {
		this.urinaryGenital = urinaryGenital;
	}

	public String getExtremities() {
		return extremities;
	}

	public void setExtremities(String extremities) {
		this.extremities = extremities;
	}

	public String getCentralNervousSystem() {
		return centralNervousSystem;
	}

	public void setCentralNervousSystem(String centralNervousSystem) {
		this.centralNervousSystem = centralNervousSystem;
	}

	public String getAffectedSystem() {
		return affectedSystem;
	}

	public void setAffectedSystem(String affectedSystem) {
		this.affectedSystem = affectedSystem;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	
}
