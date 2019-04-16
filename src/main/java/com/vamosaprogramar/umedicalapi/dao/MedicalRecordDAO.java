package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.MedicalRecord;
import com.vamosaprogramar.umedicalapi.entity.result.MedicalRecordResult;

public interface MedicalRecordDAO {

	List<MedicalRecordResult> getMedicalRecordsByPatient(int patientId);

	void addMedicalRecord(MedicalRecord medicalRecord);

	MedicalRecord getMedicalRecord(int id);

}
