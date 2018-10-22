package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.HealthEntity;

    public interface HealthEntityDAO {

    public List<HealthEntity> getHealthEntities();
	
	public HealthEntity getHealthEntity(int id);
	
	public HealthEntity getHealthEntity(String reps);
	
	public void addHealthEntity(HealthEntity healthEntity);

	public void updateHealthEntity(HealthEntity healthEntity, int id);
	
	public void deleteHealthEnity(int id);
}
