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
	
	//ZoneId de Colombia
	public static final String COLOMBIA_TIME_ZONE_ID = "America/Bogota";
	
	//Folder donde se suben los documentos
	public static final String UPLOAD_FOLDER = ".//src//main//resources//myFiles//";
	
	//Tipos de procesos
	public static final String SUBIDA_DE_PACIENTES = "SUBIDA DE PACIENTES";
	
	public static final String PACIENTES_DE_UN_CONTRATO = "PACIENTES DE UN CONTRATO";
	
	//Estados de los procesos
	public static final char EJECUCION = 'E';
	public static final char TERMINADO = 'T';
	public static final char TERMINADO_CON_INCONSISTENCIAS = 'I';
}
