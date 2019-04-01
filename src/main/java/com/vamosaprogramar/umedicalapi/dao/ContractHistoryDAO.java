package com.vamosaprogramar.umedicalapi.dao;

import java.time.LocalDate;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.ContractHistory;

public interface ContractHistoryDAO {

	public void dissociatePatients(int contractId, LocalDate finishDate);

	public void addContractHistory(ContractHistory contractHistory, Session session);
}
