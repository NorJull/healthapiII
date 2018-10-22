package com.vamosaprogramar.umedicalapi.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.dao.ProcessDAO;
import com.vamosaprogramar.umedicalapi.dao.RateManualDAO;
import com.vamosaprogramar.umedicalapi.entity.Process;
import com.vamosaprogramar.umedicalapi.entity.RateManual;

@Service
public class RateManualServiceImpl implements RateManualService {

	
	@Autowired
	private RateManualDAO rateManualDAO;
	
	@Autowired
	private ProcedureRateService procedureRateService;
	
	@Autowired
	private ProcessDAO processDAO;
	
	
	@Override
	public List<RateManual> getRateManuals() {
		
		return rateManualDAO.getRateManuals();
	}

	@Override
	public RateManual getRateManual(int id) {
	
		return rateManualDAO.getRateManual(id);
	}
	
	@Override
	public Integer addRateManual(RateManual rateManual) {
		
		return rateManualDAO.addRateManual(rateManual);
	}

	@Override
	public void deleteRateManual(int id) {
		rateManualDAO.deleteRateManual(id);
		
	}

	@Override
	public Integer uploadRateManualFile(MultipartFile rateManualFile, int id) {
		
		String uploadFolder = ".//src//main//resources//myFiles//";
		
		try {
			byte[] bytes = rateManualFile.getBytes();
			
			Path path = Paths.get(uploadFolder + rateManualFile.getOriginalFilename());
			
			Files.write(path,bytes);
			
			FileReader fileReader = new FileReader(uploadFolder + rateManualFile.getOriginalFilename());
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.mark(100000);
			String line = bufferedReader.readLine();
			int totalRows = 0;
			
			while(line!=null) {
				totalRows++;
				line = bufferedReader.readLine();
			}
			bufferedReader.reset();
			Process process = new Process(1, "TARIFAS", 'E', LocalDateTime.now(), null, totalRows,0, 0, null);
			
			Integer processId = processDAO.addProcess(process);
			
			procedureRateService.addProdedureRates(bufferedReader, id, processId, totalRows);
			
			return processId;
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	

}
