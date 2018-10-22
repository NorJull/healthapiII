package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vamosaprogramar.umedicalapi.entity.Process;

import com.vamosaprogramar.umedicalapi.service.ProcessService;

@RestController
@RequestMapping("/processes")
public class ProcessController {

	@Autowired
	private ProcessService processService;
	
	@GetMapping
	public List<Process> getProcesses(){
		return processService.getProcesses();
	}
	@GetMapping("{processId}")
	public Process getProcess(@PathVariable int processId) {
		return processService.getProcess(processId);
	}
	
	@GetMapping("{processId}/log")
	public String getLog(@PathVariable int processId) {
		
		return processService.getLog(processId);
	}
	
	@DeleteMapping("{processId}")
	public void deleteProcess(@PathVariable int processId) {
		processService.deleteProcess(processId);
	}
}
