package com.vamosaprogramar.umedicalapi.service;

import java.time.LocalDateTime;
import java.util.List;
import com.vamosaprogramar.umedicalapi.entity.Process;

public interface ProcessService {
	
	public List<Process> getProcesses();
	
	public void setLog(int processId, String log);

	public void setPercent(int processId, int currentRow,double percent);
	
	public void setStatus(int processId, char status);

	public void setFinishDate(int processId, LocalDateTime finishDate);

	public String getLog(int processId);

	public Process getProcess(int processId);

	public void deleteProcess(int processId);

}
