package com.vamosaprogramar.umedicalapi.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.entity.result.APResultado;

@Service
public class ServicioRIPSImpl implements ServicioRIPS {

	@Override
	public File obtenerAP(Integer contratoId,String factura, String fechaInicial, String fechaFinal) throws IOException {
		
	    List<APResultado> apResultados = new ArrayList<APResultado>();
	    APResultado apResultad = new APResultado("1230", "856732", "CC", "1047480954", LocalDate.now(),
	    		"008456", "A003", "XCD", "SANACION",
	    		"DOCTOR", "XDCK", "DFS", "",
	    		"", 2000);		
	    APResultado apResultad2 = new APResultado("6230", "6732", "CC", "1047650954", LocalDate.now(),
	    		"008456", "A003", "XCD", "SANACION",
	    		"DOCTOR", "XDCK", "DFS", "",
	    		"", 3400);		
	    apResultados.add(apResultad);
	    apResultados.add(apResultad2);
	    
		CSVWriter csvWriter = new CSVWriter(new FileWriter(GeneralConstants.UPLOAD_FOLDER+"AP.csv"), 
				CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
		
		 String[] encabezado = {"#FACTURA", "PRESTADOR", "TIPO ID", "#DOC", "F.PROCEDIMIENTO",
				 "#AUTORIZACION", "COD PROCEDIMIENTO", "AMBITO", "FINALIDAD PROCEDIMIENTO", "PERSONAL ATIENDE",
				 "DX PPAL", "DX REL", "COMPLICACION", "FORMA", "VL PROCEDIMIENTO"};
	    
		 csvWriter.writeNext(encabezado);
		 
		 for(APResultado apResultado : apResultados) {
			 String[] datos = apResultado.getStringArray();
			 csvWriter.writeNext(datos);
		 }
		 csvWriter.close();
		 
		 File apFile = new File(GeneralConstants.UPLOAD_FOLDER+"AP.csv");
	    return apFile;
	}

}
