package com.vamosaprogramar.umedicalapi.entity;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.TIME_FORMAT;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalTimeConverter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;

@Entity
@Table(name = "aiepi")
public class AIEPI {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "patient_id")
	private int patientId;
	
	@Column(name="date_")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate date;
	
	@Column(name = "time_")
	@Convert(converter = LocalTimeConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_FORMAT)
	private LocalTime  time;

	@Column(name = "particular")
	private String particular;
	
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
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate patientBirthDate;

	@Column(name = "patient_age")
	private int patientAge;

	@Column(name = "patient_gender")
	private String patientGender;

	@JoinColumn(name = "patient_departament_id")
	private String patientDepartament;

	@JoinColumn(name = "patient_town_id")
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

	@Column(name = "current_disease")
	private String currentDisease;

	@Column(name = "breast_feeding")
	private String breastFeeding;

	@Column(name = "vomit_all_eats")
	private String vomitAllEats;

	@Column(name = "seizures")
	private String seizures;

	@Column(name = "lethargic_unconscious")
	private String lethargicUnconscious;

	@Column(name = "difficulty_breathing")
	private String difficultyBreathing;

	@Column(name = "difficulty_breathing_days")
	private String difficultyBreathingDays;

	@Column(name = "subcostal")
	private String subcostal;

	@Column(name = "stridor")
	private String stridor;

	@Column(name = "wheezing")
	private String wheezing;

	@Column(name = "diarrhea")
	private String diarrhea;

	@Column(name = "diarrhea_days")
	private String diarrheaDays;

	@Column(name = "blood_stool")
	private String bloodStool;

	@Column(name = "restless_irritable")
	private String restlessIrritable;

	@Column(name = "sunken_eyes")
	private String sunkenEyes;

	@Column(name = "badly_drink")
	private String badlyDrink;

	@Column(name = "thirst_drink")
	private String thirstDrink;

	@Column(name = "fever")
	private String fever;

	@Column(name = "fever_days")
	private String feverDays;

	@Column(name = "fever_five_days")
	private String feverFiveDays;

	@Column(name = "fifteen_days_disease")
	private String fifteenDaysDisease;

	@Column(name = "rigid_neck")
	private String rigidNeck;

	@Column(name = "toxicity")
	private String toxicity;

	@Column(name = "abdominal_pain")
	private String abdominalPain;

	@Column(name = "wet_skin")
	private String wetSkin;

	@Column(name = "bleeding_evidence")
	private String bleedingEvidence;

	@Column(name = "exanthema")
	private String exanthema;

	@Column(name = "cough_coryza_red_eyes")
	private String coughCoryzaRedEyes;

	@Column(name = "ear_problem")
	private String earProblem;

	@Column(name = "earache")
	private String earache;

	@Column(name = "ear_oozing")
	private String earOozing;

	@Column(name = "ear_oozing_days")
	private String earOozing_days;

	@Column(name = "ear_oozing_times")
	private String earOozing_times;

	@Column(name = "red_eardrum")
	private String redEardrum;

	@Column(name = "inflammation_behind_ear")
	private String inflammationBehindEar;

	@Column(name = "throat_problem")
	private String throatProblem;

	@Column(name = "sore_throat")
	private String soreThroat;

	@Column(name = "neck_nodes")
	private String neckNodes;

	@Column(name = "white_fluid_tonsils")
	private String whiteFluidTonsils;

	@Column(name = "erythematous_throat")
	private String erythematousThroat;

	@Column(name = "suggestive_physical_injury")
	private String suggestivePhysicalInjury;

	@Column(name = "genital_physical_injury")
	private String genitalPhysicalInjury;

	@Column(name = "says_victim_abuse")
	private String saysVictimAbuse;

	@Column(name = "behavior_alteration_child")
	private String behaviorAlterationChild;

	@Column(name = "behavior_alteration_caregivers")
	private String behaviorAlterationCaregivers;

	@Column(name = "neglected_hygiene")
	private String neglectedHygiene;

	@Column(name = "neglected_health")
	private String neglectedHealth;

	@Column(name = "disabled")
	private String disabled;

	@Column(name = "emaciation")
	private String emaciation;

	@Column(name = "pale_hands")
	private String paleHands;

	@Column(name = "feet_edema")
	private String feetEdema;

	@Column(name = "activities_of_age")
	private String activitiesOfAge;

	@Column(name = "activities_prev_age")
	private String activitiesPrevAge;

	@Column(name = "pregnancy")
	private String pregnancy;

	@Column(name = "birth")
	private String birth;

	@Column(name = "birth_weight")
	private String birthWeight;

	@Column(name = "birth_problem")
	private String birthProblem;

	@Column(name = "serious_health_problem")
	private String seriousHealthProblem;

	@Column(name = "family_parents")
	private String familyParents;

	@Column(name = "physical_mental_family")
	private String physicalMentalFamily;

	@Column(name = "child_development")
	private String childDevelopment;

	@Column(name = "heart_rate")
	private String heartRate;

	@Column(name = "breath_rate")
	private String breathRate;

	@Column(name = "tension")
	private String tension;

	@Column(name = "body_temp")
	private String bodyTemp;

	@Column(name = "size")
	private String size;

	@Column(name = "weight")
	private String weight;

	@Column(name = "bmi")
	private String bmi;

	@Column(name = "signs_symptoms")
	private String signsSymptoms;

	@Column(name = "recommendations")
	private String recommendations;

	@Column(name = "return_immediately")
	private String returnImmediately;

	@Column(name = "return_control_consult")
	private String returnControlConsult;

	@Column(name = "return_healthy_consult")
	private String returnHealthyConsult;

	@Column(name = "referred")
	private String referred;

	@Column(name = "preventive_measures")
	private String preventiveMeasures;

	@Column(name = "good_treatment_recommend")
	private String goodTreatmentRecommend;

	public AIEPI() {
		
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

	public LocalDate getPatientBirthDate() {
		return patientBirthDate;
	}

	public void setPatientBirthDate(LocalDate patientBirthDate) {
		this.patientBirthDate = patientBirthDate;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
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

	public String getCurrentDisease() {
		return currentDisease;
	}

	public void setCurrentDisease(String currentDisease) {
		this.currentDisease = currentDisease;
	}

	public String getBreastFeeding() {
		return breastFeeding;
	}

	public void setBreastFeeding(String breastFeeding) {
		this.breastFeeding = breastFeeding;
	}

	public String getVomitAllEats() {
		return vomitAllEats;
	}

	public void setVomitAllEats(String vomitAllEats) {
		this.vomitAllEats = vomitAllEats;
	}

	public String getSeizures() {
		return seizures;
	}

	public void setSeizures(String seizures) {
		this.seizures = seizures;
	}

	public String getLethargicUnconscious() {
		return lethargicUnconscious;
	}

	public void setLethargicUnconscious(String lethargicUnconscious) {
		this.lethargicUnconscious = lethargicUnconscious;
	}

	public String getDifficultyBreathing() {
		return difficultyBreathing;
	}

	public void setDifficultyBreathing(String difficultyBreathing) {
		this.difficultyBreathing = difficultyBreathing;
	}

	public String getDifficultyBreathingDays() {
		return difficultyBreathingDays;
	}

	public void setDifficultyBreathingDays(String difficultyBreathingDays) {
		this.difficultyBreathingDays = difficultyBreathingDays;
	}

	public String getSubcostal() {
		return subcostal;
	}

	public void setSubcostal(String subcostal) {
		this.subcostal = subcostal;
	}

	public String getStridor() {
		return stridor;
	}

	public void setStridor(String stridor) {
		this.stridor = stridor;
	}

	public String getWheezing() {
		return wheezing;
	}

	public void setWheezing(String wheezing) {
		this.wheezing = wheezing;
	}

	public String getDiarrhea() {
		return diarrhea;
	}

	public void setDiarrhea(String diarrhea) {
		this.diarrhea = diarrhea;
	}

	public String getDiarrheaDays() {
		return diarrheaDays;
	}

	public void setDiarrheaDays(String diarrheaDays) {
		this.diarrheaDays = diarrheaDays;
	}

	public String getBloodStool() {
		return bloodStool;
	}

	public void setBloodStool(String bloodStool) {
		this.bloodStool = bloodStool;
	}

	public String getRestlessIrritable() {
		return restlessIrritable;
	}

	public void setRestlessIrritable(String restlessIrritable) {
		this.restlessIrritable = restlessIrritable;
	}

	public String getSunkenEyes() {
		return sunkenEyes;
	}

	public void setSunkenEyes(String sunkenEyes) {
		this.sunkenEyes = sunkenEyes;
	}

	public String getBadlyDrink() {
		return badlyDrink;
	}

	public void setBadlyDrink(String badlyDrink) {
		this.badlyDrink = badlyDrink;
	}

	public String getThirstDrink() {
		return thirstDrink;
	}

	public void setThirstDrink(String thirstDrink) {
		this.thirstDrink = thirstDrink;
	}

	public String getFever() {
		return fever;
	}

	public void setFever(String fever) {
		this.fever = fever;
	}

	public String getFeverDays() {
		return feverDays;
	}

	public void setFeverDays(String feverDays) {
		this.feverDays = feverDays;
	}

	public String getFeverFiveDays() {
		return feverFiveDays;
	}

	public void setFeverFiveDays(String feverFiveDays) {
		this.feverFiveDays = feverFiveDays;
	}

	public String getFifteenDaysDisease() {
		return fifteenDaysDisease;
	}

	public void setFifteenDaysDisease(String fifteenDaysDisease) {
		this.fifteenDaysDisease = fifteenDaysDisease;
	}

	public String getRigidNeck() {
		return rigidNeck;
	}

	public void setRigidNeck(String rigidNeck) {
		this.rigidNeck = rigidNeck;
	}

	public String getToxicity() {
		return toxicity;
	}

	public void setToxicity(String toxicity) {
		this.toxicity = toxicity;
	}

	public String getAbdominalPain() {
		return abdominalPain;
	}

	public void setAbdominalPain(String abdominalPain) {
		this.abdominalPain = abdominalPain;
	}

	public String getWetSkin() {
		return wetSkin;
	}

	public void setWetSkin(String wetSkin) {
		this.wetSkin = wetSkin;
	}

	public String getBleedingEvidence() {
		return bleedingEvidence;
	}

	public void setBleedingEvidence(String bleedingEvidence) {
		this.bleedingEvidence = bleedingEvidence;
	}

	public String getExanthema() {
		return exanthema;
	}

	public void setExanthema(String exanthema) {
		this.exanthema = exanthema;
	}

	public String getCoughCoryzaRedEyes() {
		return coughCoryzaRedEyes;
	}

	public void setCoughCoryzaRedEyes(String coughCoryzaRedEyes) {
		this.coughCoryzaRedEyes = coughCoryzaRedEyes;
	}

	public String getEarProblem() {
		return earProblem;
	}

	public void setEarProblem(String earProblem) {
		this.earProblem = earProblem;
	}

	public String getEarache() {
		return earache;
	}

	public void setEarache(String earache) {
		this.earache = earache;
	}

	public String getEarOozing() {
		return earOozing;
	}

	public void setEarOozing(String earOozing) {
		this.earOozing = earOozing;
	}

	public String getEarOozing_days() {
		return earOozing_days;
	}

	public void setEarOozing_days(String earOozing_days) {
		this.earOozing_days = earOozing_days;
	}

	public String getEarOozing_times() {
		return earOozing_times;
	}

	public void setEarOozing_times(String earOozing_times) {
		this.earOozing_times = earOozing_times;
	}

	public String getRedEardrum() {
		return redEardrum;
	}

	public void setRedEardrum(String redEardrum) {
		this.redEardrum = redEardrum;
	}

	public String getInflammationBehindEar() {
		return inflammationBehindEar;
	}

	public void setInflammationBehindEar(String inflammationBehindEar) {
		this.inflammationBehindEar = inflammationBehindEar;
	}

	public String getThroatProblem() {
		return throatProblem;
	}

	public void setThroatProblem(String throatProblem) {
		this.throatProblem = throatProblem;
	}

	public String getSoreThroat() {
		return soreThroat;
	}

	public void setSoreThroat(String soreThroat) {
		this.soreThroat = soreThroat;
	}

	public String getNeckNodes() {
		return neckNodes;
	}

	public void setNeckNodes(String neckNodes) {
		this.neckNodes = neckNodes;
	}

	public String getWhiteFluidTonsils() {
		return whiteFluidTonsils;
	}

	public void setWhiteFluidTonsils(String whiteFluidTonsils) {
		this.whiteFluidTonsils = whiteFluidTonsils;
	}

	public String getErythematousThroat() {
		return erythematousThroat;
	}

	public void setErythematousThroat(String erythematousThroat) {
		this.erythematousThroat = erythematousThroat;
	}

	public String getSuggestivePhysicalInjury() {
		return suggestivePhysicalInjury;
	}

	public void setSuggestivePhysicalInjury(String suggestivePhysicalInjury) {
		this.suggestivePhysicalInjury = suggestivePhysicalInjury;
	}

	public String getGenitalPhysicalInjury() {
		return genitalPhysicalInjury;
	}

	public void setGenitalPhysicalInjury(String genitalPhysicalInjury) {
		this.genitalPhysicalInjury = genitalPhysicalInjury;
	}

	public String getSaysVictimAbuse() {
		return saysVictimAbuse;
	}

	public void setSaysVictimAbuse(String saysVictimAbuse) {
		this.saysVictimAbuse = saysVictimAbuse;
	}

	public String getBehaviorAlterationChild() {
		return behaviorAlterationChild;
	}

	public void setBehaviorAlterationChild(String behaviorAlterationChild) {
		this.behaviorAlterationChild = behaviorAlterationChild;
	}

	public String getBehaviorAlterationCaregivers() {
		return behaviorAlterationCaregivers;
	}

	public void setBehaviorAlterationCaregivers(String behaviorAlterationCaregivers) {
		this.behaviorAlterationCaregivers = behaviorAlterationCaregivers;
	}

	public String getNeglectedHygiene() {
		return neglectedHygiene;
	}

	public void setNeglectedHygiene(String neglectedHygiene) {
		this.neglectedHygiene = neglectedHygiene;
	}

	public String getNeglectedHealth() {
		return neglectedHealth;
	}

	public void setNeglectedHealth(String neglectedHealth) {
		this.neglectedHealth = neglectedHealth;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getEmaciation() {
		return emaciation;
	}

	public void setEmaciation(String emaciation) {
		this.emaciation = emaciation;
	}

	public String getPaleHands() {
		return paleHands;
	}

	public void setPaleHands(String paleHands) {
		this.paleHands = paleHands;
	}

	public String getFeetEdema() {
		return feetEdema;
	}

	public void setFeetEdema(String feetEdema) {
		this.feetEdema = feetEdema;
	}

	public String getActivitiesOfAge() {
		return activitiesOfAge;
	}

	public void setActivitiesOfAge(String activitiesOfAge) {
		this.activitiesOfAge = activitiesOfAge;
	}

	public String getActivitiesPrevAge() {
		return activitiesPrevAge;
	}

	public void setActivitiesPrevAge(String activitiesPrevAge) {
		this.activitiesPrevAge = activitiesPrevAge;
	}

	public String getPregnancy() {
		return pregnancy;
	}

	public void setPregnancy(String pregnancy) {
		this.pregnancy = pregnancy;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(String birthWeight) {
		this.birthWeight = birthWeight;
	}

	public String getBirthProblem() {
		return birthProblem;
	}

	public void setBirthProblem(String birthProblem) {
		this.birthProblem = birthProblem;
	}

	public String getSeriousHealthProblem() {
		return seriousHealthProblem;
	}

	public void setSeriousHealthProblem(String seriousHealthProblem) {
		this.seriousHealthProblem = seriousHealthProblem;
	}

	public String getFamilyParents() {
		return familyParents;
	}

	public void setFamilyParents(String familyParents) {
		this.familyParents = familyParents;
	}

	public String getPhysicalMentalFamily() {
		return physicalMentalFamily;
	}

	public void setPhysicalMentalFamily(String physicalMentalFamily) {
		this.physicalMentalFamily = physicalMentalFamily;
	}

	public String getChildDevelopment() {
		return childDevelopment;
	}

	public void setChildDevelopment(String childDevelopment) {
		this.childDevelopment = childDevelopment;
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

	public String getTension() {
		return tension;
	}

	public void setTension(String tension) {
		this.tension = tension;
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

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getSignsSymptoms() {
		return signsSymptoms;
	}

	public void setSignsSymptoms(String signsSymptoms) {
		this.signsSymptoms = signsSymptoms;
	}

	public String getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

	public String getReturnImmediately() {
		return returnImmediately;
	}

	public void setReturnImmediately(String returnImmediately) {
		this.returnImmediately = returnImmediately;
	}

	public String getReturnControlConsult() {
		return returnControlConsult;
	}

	public void setReturnControlConsult(String returnControlConsult) {
		this.returnControlConsult = returnControlConsult;
	}

	public String getReturnHealthyConsult() {
		return returnHealthyConsult;
	}

	public void setReturnHealthyConsult(String returnHealthyConsult) {
		this.returnHealthyConsult = returnHealthyConsult;
	}

	public String getReferred() {
		return referred;
	}

	public void setReferred(String referred) {
		this.referred = referred;
	}

	public String getPreventiveMeasures() {
		return preventiveMeasures;
	}

	public void setPreventiveMeasures(String preventiveMeasures) {
		this.preventiveMeasures = preventiveMeasures;
	}

	public String getGoodTreatmentRecommend() {
		return goodTreatmentRecommend;
	}

	public void setGoodTreatmentRecommend(String goodTreatmentRecommend) {
		this.goodTreatmentRecommend = goodTreatmentRecommend;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}
	
		

}
