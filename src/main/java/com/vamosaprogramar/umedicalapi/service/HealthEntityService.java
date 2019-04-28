package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.Contrato;
import com.vamosaprogramar.umedicalapi.entity.HealthEntity;

public interface HealthEntityService {

	public List<HealthEntity> getHealthEntities();
	
	public HealthEntity getHealthEntity(int id);
	
	public void addHealthEntity(HealthEntity healthEntity);

	public void updateHealthEntity(HealthEntity healthEntity, int id);
	
	public void deleteHealthEnity(int id);

	public List<Contrato> getContractsByHealthEntity(int healthEntityId);
	
	
}
