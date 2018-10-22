package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.HealthEntityDAO;
import com.vamosaprogramar.umedicalapi.entity.Contract;
import com.vamosaprogramar.umedicalapi.entity.HealthEntity;

@Service
public class HealthEntityServiceImpl implements HealthEntityService {
	
	@Autowired
	private HealthEntityDAO healthEntityDAO;
	
	@Autowired
	private ContractService contractService;
	
	@Override
	public List<HealthEntity> getHealthEntities() {
		
		return healthEntityDAO.getHealthEntities();
	}

	@Override
	public HealthEntity getHealthEntity(int id) {

		return healthEntityDAO.getHealthEntity(id);
	}

	@Override
	public void addHealthEntity(HealthEntity healthEntity) {
		healthEntityDAO.addHealthEntity(healthEntity);
	}

	@Override
	public void updateHealthEntity(HealthEntity healthEntity, int id) {
		healthEntityDAO.updateHealthEntity(healthEntity, id);

	}

	@Override
	public void deleteHealthEnity(int id) {
		healthEntityDAO.deleteHealthEnity(id);

	}

	@Override
	public List<Contract> getContractsByHealthEntity(int healthEntityId) {
		
		return contractService.getContractsByHealthEntity(healthEntityId);
	}

}
