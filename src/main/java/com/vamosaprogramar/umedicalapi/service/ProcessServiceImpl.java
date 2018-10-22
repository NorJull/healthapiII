package com.vamosaprogramar.umedicalapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.ProcessDAO;
import com.vamosaprogramar.umedicalapi.entity.Process;
@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private ProcessDAO processDAO;
	
	@Override
	public List<Process> getProcesses() {
		return processDAO.getProcesses();
	}

	@Override
	public void setLog(int processId, String log) {
		processDAO.setLog(processId, log);
		
	}
	
	@Override
	public void setPercent(int processId, int currentRow, double percent) {
		processDAO.setPercent(processId,currentRow, percent);
	}

	@Override
	public void setStatus(int processId, char status) {
		processDAO.setStatus(processId,status);
		
	}

	@Override
	public void setFinishDate(int processId, LocalDateTime finishDate) {
		processDAO.setFinishDate(processId,  finishDate);
		
	}

	@Override
	public String getLog(int processId) {
		
		return processDAO.getLog(processId);
	}

	@Override
	public Process getProcess(int processId) {
		
		return processDAO.getProcess(processId);
	}

	@Override
	public void deleteProcess(int processId) {
		processDAO.deleteProcess(processId);
		
	}

}
