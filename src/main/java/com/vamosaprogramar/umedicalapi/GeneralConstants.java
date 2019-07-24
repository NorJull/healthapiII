package com.vamosaprogramar.umedicalapi;

import java.time.format.DateTimeFormatter;

public class GeneralConstants {

	public static String APPOINTMENT_STATE_SCHEDULED = "R";
	public static String APPOINTMENT_STATE_CANCELED = "C";
	public static String APPOINTMENT_STATE_FINISHED = "F";
	
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
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
	
	//Formato de hora
	public static final String TIME_FORMAT = "HH:mm";
	
	//Formato fecha y hora
	public static final String DATA_TIME_FORMAT = "dd/MM/yyyy hh:mm:ss";
	
	//ZoneId de Colombia
	public static final String COLOMBIA_TIME_ZONE_ID = "America/Bogota";
	
	//Folder donde se suben los documentos
	public static final String UPLOAD_FOLDER = ".//src//main//resources//myFiles//";
	
	//Folder donde se suben 
	
	//Tipos de procesos
	public static final String SUBIDA_DE_PACIENTES = "SUBIDA DE PACIENTES";
	
	public static final String PACIENTES_DE_UN_CONTRATO = "PACIENTES DE UN CONTRATO";
	
	public static final String PROCEDIMIENTOS_DE_UN_CONTRATO = "PROCEDIMIENTOS DE UN CONTRATO";
	
	public static final String SUBIDA_DE_PROCEDIMIENTOS = "SUBIDA DE PROCEDIMIENTOS";	
	
	public static final String PROCEDIMIENTOS_DE_UNA_ESPECIALIDAD = "PROCEDIMIENTOS DE UNA ESPECIALIDAD";
	
	public static final String SUBIDA_DE_MUNUAL_TARIFARIO = "SUBIDA DE MANUAL TARIFARIO";	
	
	
	
	//Estados de los procesos
	public static final char EJECUCION = 'E';
	public static final char TERMINADO = 'T';
	public static final char TERMINADO_CON_INCONSISTENCIAS = 'I';
	
	//Procedimiento particular o no
	public static final char PARTICULAR = 'S';
	public static final char NO_PARTICULAR = 'N';
	
	//Estados de procedimientos ordenados
	public static final String EJECUTADO = "E";
	public static final String ORDENADO = "O";
}
