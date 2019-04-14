package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.MedicalRecord;

public interface MedicalRecordDAO {

	List<MedicalRecord> getMedicalRecordsByPatient(int patientId);

	void addMedicalRecord(MedicalRecord medicalRecord);

}
