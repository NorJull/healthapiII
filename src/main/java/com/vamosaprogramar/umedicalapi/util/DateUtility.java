package com.vamosaprogramar.umedicalapi.util;

import java.time.LocalDate;

public class DateUtility {
	
	public static int getFinishDayOfTheMonth(int year,int month) {
		
		LocalDate startDate = LocalDate.of(year, month, 1);
		
		LocalDate finishDateMinusOneDay = startDate.plusMonths(1).minusDays(1);
		
		int day = finishDateMinusOneDay.getDayOfMonth();
	
		return day;
	}

}
