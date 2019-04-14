package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.MedicalRecord;

public interface MedicalRecordService {

	List<MedicalRecord> getMedicalRecordsByPatient(int patientId);

	void addMedicalRecord(MedicalRecord medicalRecord);

}
