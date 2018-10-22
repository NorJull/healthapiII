package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.ScheduleDAO;
import com.vamosaprogramar.umedicalapi.dao.SpecialityDAO;
import com.vamosaprogramar.umedicalapi.dao.UserDAO;
import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.Schedule;
import com.vamosaprogramar.umedicalapi.entity.Speciality;
import com.vamosaprogramar.umedicalapi.exception.ScheduleException;
import com.vamosaprogramar.umedicalapi.exception.SpecialityDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.UserDoesNotExist;




@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ScheduleDAO scheduleDAO;
	
	@Autowired
	private SpecialityDAO specialityDAO;
	
	
	@Override
	public ApplicationUser findByUsername(String username) {
		return userDAO.findByUsername(username);
	}


	@Override
	public void saveUser(ApplicationUser user) throws ScheduleException, UserDoesNotExist, SpecialityDoesNotExist {
		
		ApplicationUser auxiliaryUser = new ApplicationUser(user.getUsername(), user.getPassword());
		auxiliaryUser.setDocument(user.getDocument());
		auxiliaryUser.setProfessionalCard(user.getProfessionalCard());
		auxiliaryUser.setUserType(user.getUserType());
		auxiliaryUser.setSpecialities(user.getSpecialities());
		auxiliaryUser.setPhoneNumber(user.getPhoneNumber());
		auxiliaryUser.setEmail(user.getEmail());
		auxiliaryUser.setName1(user.getName1());
		auxiliaryUser.setName2(user.getName2());
		auxiliaryUser.setLastName1(user.getLastName1());
		auxiliaryUser.setLastName2(user.getLastName2());
		auxiliaryUser.setUserType(user.getUserType());
		
		System.out.println("Prueba::::::::::::"+auxiliaryUser);
		
		Integer userId = userDAO.saveUser(auxiliaryUser);
		
		System.out.println("Llamando al añadir horarios: "+user.getSchedules()+" Con ID "+userId);
		if(user.getSchedules()!=null)
			addSchedules(user.getSchedules(),  userId);
	}


	@Override
	public List<ApplicationUser> getUsers() {
		return userDAO.getUsers();
	}



	@Override
	public void addSchedules(List<Schedule> schedules, int id) throws ScheduleException, UserDoesNotExist, SpecialityDoesNotExist {
		
		
		/*Inicia: Validar que este doctor no tenga citas en estado (Agendada)
			
			Si el doctor tiene citas agendadas lanzar ScheduleException
		
		Fin:    Validar que este doctor no tenga citas en estado (Agendada)
		*/
		
		for(Schedule schedule : schedules) {
			System.out.println("SERVICIO: "+schedule);
			
			Schedule temporalSchedule = scheduleDAO.getScheduleByUserIdAndWeekDay(id, schedule.getWeekDay());
		
			
			ApplicationUser user = userDAO.getUser(id);
			
			if(user==null)
				throw new UserDoesNotExist();
			
			
			if(temporalSchedule==null) {
				//Crear nuevo registro
				
				//Validaciones sobre la especialidad
				if(schedule.getSpeciality()==null)
					throw new SpecialityDoesNotExist();
				
				Speciality speciality = specialityDAO.getSpeciality(schedule.getSpeciality().getId());
														
				if(speciality==null)
					throw new SpecialityDoesNotExist();
				
								
				//Añadir schedule
				userDAO.addSchedule(schedule, id);
				
			}else {

				schedule.setId(temporalSchedule.getId());
				userDAO.updateSchedule(schedule);
				
			}
			
			
		}
		
				
	}


	@Override
	public List<Schedule> getSchedules(int id) {
		// TODO Auto-generated method stub
		return userDAO.getSchedules(id);
	}

}
