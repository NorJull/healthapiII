package com.vamosaprogramar.umedicalapi.service.async;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.PatientDAO;
import com.vamosaprogramar.umedicalapi.entity.Departament;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.Town;
import com.vamosaprogramar.umedicalapi.exception.IncompleteRow;
import com.vamosaprogramar.umedicalapi.service.ProcessService;

@Service
public class PatientServiceAsyncImpl implements PatientServiceAsync {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ProcessService processService;
	
	@Autowired 
	private PatientDAO patientDAO;
	
	
	@Override
	@Async
	public void addPatients(BufferedReader bufferedReader,int processId, int totalRows) {
		
		
		String log = "";
		Session session = null;
		int currentRow = 1;
		double percent = 0;
		int batchSize = 25;
		//Cuando sea true se hace un update sobre los datos del paciente
		//En caso contrario se crea un nuevo paciente
		boolean update = false; 
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			String line = bufferedReader.readLine();
			String[] parts;
			
			ProcedureType procedureType;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			
		
			while(line!=null) {  
				
				if(currentRow%batchSize == 0) {
					session.getTransaction().commit();
					
					//Actualizar porcentaje de ejecución
					percent = ((double) currentRow/totalRows)*100;
					processService.setPercent(processId, currentRow, percent);
					
					session.beginTransaction();
				}
				
				System.out.println(line);
				
				parts = line.split(Pattern.quote(";"));
				
				
				try {
					
					//Validación 1: Registro incompleto
					if(parts.length!=30) { 
						throw new IncompleteRow();
					}
					
					//Ir a base de datos y preguntar si existe un paciente con ese documento de identidad
					Patient patient = patientDAO.getPatientByDocument(parts[2],session);
					
					if(patient==null) {
						patient = new Patient();
					}else {
						update = true;
					}
	
						
					
					//Carnet
					if((!parts[0].trim().isEmpty())&&(update==false)) 
						patient.setCarnet(parts[0].trim());
					
					//Tipo de documento
					if(!parts[1].trim().isEmpty())
						patient.setDocumentType(parts[1].trim());
					
					//Número de documento
					if(!parts[2].trim().isEmpty())
						patient.setDocument(parts[2].trim());
					
					//Primer apellido
					if(!parts[3].trim().isEmpty())
						patient.setLastName1(parts[3].trim());
					
					//Segundo apellido
					if(!parts[4].trim().isEmpty())
						patient.setLastName2(parts[4].trim());
					
					//Primer nombre
					if(!parts[5].trim().isEmpty())
						patient.setName1(parts[5].trim());
					
					//Segundo nombre
					if(!parts[6].trim().isEmpty())
						patient.setName2(parts[6].trim());
					
					//Fecha de nacimiento
					if(!parts[7].trim().isEmpty()){
						
						//convert String to LocalDate
						LocalDate localDate = LocalDate.parse(parts[7].trim(), formatter);
						
						patient.setBirthDate(localDate);
					}
					
					//Edad
					if(!parts[8].trim().isEmpty())
						patient.setAge(Integer.parseInt(parts[8].trim()));
						
					//Genero
					if(!parts[9].trim().isEmpty())
						patient.setGender(parts[9].trim());
					
					//Sisben
					if(!parts[10].trim().isEmpty())
						patient.setSisben(parts[10].trim());
					
					//Nivel de sisben
					if(!parts[11].trim().isEmpty())
						patient.setSisbenLevel(parts[11].trim());
					
					//Número del barrio
					if(!parts[12].trim().isEmpty())
						patient.setNeighborhoodNumber(parts[12].trim());
					  
					//Barrio
					if(!parts[13].trim().isEmpty())
						patient.setNeighborhood(parts[15].trim());
					
					//Departamento
					if(!parts[13].trim().isEmpty()) {
						
						Departament departament = new Departament();
						departament.setId(Integer.parseInt(parts[13].trim()));
						patient.setDepartament(departament);
					}
					
					//Ciudad
					if(!parts[14].trim().isEmpty()) {
						
						Town town = new Town();
						town.setId(Integer.parseInt(parts[14].trim()));
						patient.setTown(town);
					}
					
					//Dirección
					if(!parts[16].trim().isEmpty())
						patient.setAddress(parts[16].trim());
					
					//Número de IPS
					if(!parts[17].trim().isEmpty())
						patient.setIpsNumber(parts[17].trim());
					
					//IPS
					if(!parts[18].trim().isEmpty())
						patient.setIps(parts[18].trim());
					
					//Zona
					if(!parts[19].trim().isEmpty())
						patient.setZone(parts[19].trim());
					
					//Fecha de afiliación
					if(!parts[20].trim().isEmpty()){
						
						//convert String to LocalDate
						LocalDate localDate = LocalDate.parse(parts[20].trim(), formatter);
						
						patient.setMembershipDate(localDate);
					}
					
					//Número de telefono
					if(!parts[21].trim().isEmpty()) {
						patient.setPhoneNumber(parts[21].trim());
					}
					
					//Fosyga
					if(!parts[22].trim().isEmpty())
						patient.setFosyga(parts[22].trim());
					
					//Huella
					if(!parts[23].trim().isEmpty()) 
						patient.setFingerprint(parts[23].trim());
					
					//Tipo de población
					if(!parts[24].trim().isEmpty())
						patient.setPoblationType(parts[24].trim());
					
					//Estado
					if(!parts[25].trim().isEmpty())
						patient.setState(parts[25].trim());
					
					//Regimen
					if(!parts[26].trim().isEmpty())
						patient.setRegime(parts[26].trim());
					
					//Tipo de afiliación
					if(!parts[27].trim().isEmpty())
						patient.setMembershipType(parts[27].trim());
					
					//Salario
					if(!parts[28].trim().isEmpty())
						patient.setSalary(parts[28].trim());
					
					//Categoria
					if(!parts[29].trim().isEmpty())
						patient.setCategory(parts[29].trim());
					
					
					if(update == false) {
						
						//Crear paciente
						patientDAO.addPatient(patient, session);
					}else {  
						//Actualizar paciente
						patientDAO.updatePatient(patient, session);
						update = false;
					}
					
						
					
					
				}catch (IncompleteRow e) {
					log = log +"\n"+"Line "+currentRow+">>"+parts[0]+";"+parts[1]+";"+parts[2]+"... :"+ e.getMessage();
					
				}catch (NumberFormatException e) {
					log = log +"\n"+"Line "+currentRow+">>"+parts[0]+";"+parts[1]+";"+parts[2]+"... :"+ e.getMessage();
				}catch(DateTimeParseException e) {
					log = log +"\n"+"Line "+currentRow+">>"+parts[0]+";"+parts[1]+";"+parts[2]+"... :"+ e.getMessage();
				}catch(DataIntegrityViolationException e) {
					log = log +"\n"+"Line "+currentRow+">>"+parts[0]+";"+parts[1]+";"+parts[2]+"... :"+ e.getMessage();
				}catch(ConstraintViolationException e) {
					log = log +"\n"+"Line "+currentRow+">>"+parts[0]+";"+parts[1]+";"+parts[2]+"... :"+ e.getMessage();
				}
				
				
				
				currentRow++;
				line = bufferedReader.readLine();
				
			}
				
			currentRow--;
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			processService.setLog(processId, log);
			
			percent = ((double) currentRow/totalRows)*100;
			processService.setPercent(processId, currentRow, percent);

			processService.setFinishDate(processId, LocalDateTime.now());
			
			if(log.equals("")) {
				processService.setStatus(processId, 'T');//T:terminado
			}else {
				processService.setStatus(processId, 'I');//I:Terminado con inconsistencias
			}
			
			if (session.isOpen()) {
				session.close();
		}
		
		
		}
		
		
	}

}
