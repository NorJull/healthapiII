package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.MedicalRecordDAO;
import com.vamosaprogramar.umedicalapi.entity.MedicalRecord;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

	@Autowired
	private MedicalRecordDAO medicalRecordDAO;
	
	@Override
	public List<MedicalRecord> getMedicalRecordsByPatient(int patientId) {
		return medicalRecordDAO.getMedicalRecordsByPatient(patientId);
	}

	@Override
	public void addMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecordDAO.addMedicalRecord(medicalRecord);	
	}

}
