package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.Schedule;

public interface ScheduleDAO {

	public Schedule getScheduleByUserIdAndWeekDay(int userId, int weekDay);

	public List<Schedule> getScheduleOfOneSpeciality(int specialityId);

	public List<Schedule> getScheduleByDoctorAndSpeciality(int specialityId, int doctorId);
}
