package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.Contract;
import com.vamosaprogramar.umedicalapi.entity.HealthEntity;

public interface HealthEntityService {

	public List<HealthEntity> getHealthEntities();
	
	public HealthEntity getHealthEntity(int id);
	
	public void addHealthEntity(HealthEntity healthEntity);

	public void updateHealthEntity(HealthEntity healthEntity, int id);
	
	public void deleteHealthEnity(int id);

	public List<Contract> getContractsByHealthEntity(int healthEntityId);
	
	
}
