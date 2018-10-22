package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.Schedule;
import com.vamosaprogramar.umedicalapi.exception.ScheduleException;
import com.vamosaprogramar.umedicalapi.exception.SpecialityDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.UserDoesNotExist;

public interface UserService {

	public ApplicationUser findByUsername(String username);

	public void saveUser(ApplicationUser user) throws ScheduleException, UserDoesNotExist, SpecialityDoesNotExist;

	public List<ApplicationUser> getUsers();

	public void addSchedules(List<Schedule> schedules, int id) throws ScheduleException, UserDoesNotExist, SpecialityDoesNotExist;

	public List<Schedule> getSchedules(int id);
	
}
