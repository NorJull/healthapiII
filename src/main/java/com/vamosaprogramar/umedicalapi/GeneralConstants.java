package com.vamosaprogramar.umedicalapi;

public class GeneralConstants {

	public static String APPOINTMENT_STATE_SCHEDULED = "R";
	public static String APPOINTMENT_STATE_CANCELED = "C";
	
	//Valor por defecto cuando no se envia el parametro doctor
	public static int    ALL_DOCTORS_ID = 0;
	
	//Dias de la semana
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;
	public static final int SUNDAY = 7;
	
	//Formato de fecha 
	public static final String DATE_FORMAT = "dd/MM/yyyy";

	//Formato de hora
	public static final String TIME_FORMAT = "HH:mm";
	
	//Formato fecha y hora
	public static final String DATA_TIME_FORMAT = "dd/MM/yyyy hh:mm:ss";
}
