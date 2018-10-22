package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.Schedule;
import com.vamosaprogramar.umedicalapi.exception.SpecialityDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.UserDoesNotExist;

public interface UserDAO {

	public ApplicationUser findByUsername(String username);

	public Integer saveUser(ApplicationUser user);

	public List<ApplicationUser> getUsers();

	public void addSchedule(Schedule schedule, int id) throws UserDoesNotExist, SpecialityDoesNotExist;

	public List<Schedule> getSchedules(int id);

	public ApplicationUser getUser(int id);

	public void updateSchedule(Schedule schedule);
}
