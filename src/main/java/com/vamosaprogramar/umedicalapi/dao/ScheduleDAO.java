package com.vamosaprogramar.umedicalapi.dao;

import com.vamosaprogramar.umedicalapi.entity.Schedule;

public interface ScheduleDAO {

	public Schedule getScheduleByUserIdAndWeekDay(int userId, int weekDay);
}
