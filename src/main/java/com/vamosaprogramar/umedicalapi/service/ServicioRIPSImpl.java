package com.vamosaprogramar.umedicalapi.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.dao.RIPSDAO;
import com.vamosaprogramar.umedicalapi.entity.result.ACResultado;
import com.vamosaprogramar.umedicalapi.entity.result.APResultado;

@Service
public class ServicioRIPSImpl implements ServicioRIPS {

	@Autowired
	private RIPSDAO ripsDAO;

	@Override
	public File obtenerAP(Integer contratoId, String factura, String fechaInicial, String fechaFinal)
			throws IOException {

		String dia = fechaInicial.substring(0, 2);
		String mes = fechaInicial.substring(2, 4);
		String ano = fechaInicial.substring(4, 8);
		fechaInicial = dia + "/" + mes + "/" + ano;
		dia = fechaFinal.substring(0, 2);
		mes = fechaFinal.substring(2, 4);
		ano = fechaFinal.substring(4, 8);
		fechaFinal = dia + "/" + mes + "/" + ano;

		List<APResultado> apResultados = ripsDAO.obtenerAP(contratoId, factura, fechaInicial, fechaFinal);

		CSVWriter csvWriter = new CSVWriter(new FileWriter(GeneralConstants.UPLOAD_FOLDER + "AP.csv"),
				CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
				CSVWriter.DEFAULT_LINE_END);

		String[] encabezado = { "#FACTURA", "PRESTADOR", "TIPO ID", "#DOC", "F.PROCEDIMIENTO", "#AUTORIZACION",
				"COD PROCEDIMIENTO", "AMBITO", "FINALIDAD PROCEDIMIENTO", "PERSONAL ATIENDE", "DX PPAL", "DX REL",
				"COMPLICACION", "FORMA", "VL PROCEDIMIENTO" };

		csvWriter.writeNext(encabezado);

		for (APResultado apResultado : apResultados) {
			String[] datos = apResultado.getStringArray();
			csvWriter.writeNext(datos);
		}
		csvWriter.close();

		File apFile = new File(GeneralConstants.UPLOAD_FOLDER + "AP.csv");
		return apFile;
	}

	@Override
	public File obtenerAC(Integer contratoId, String factura, String fechaInicial, String fechaFinal)
			throws IOException {
		String dia = fechaInicial.substring(0, 2);
		String mes = fechaInicial.substring(2, 4);
		String ano = fechaInicial.substring(4, 8);
		fechaInicial = dia + "/" + mes + "/" + ano;
		dia = fechaFinal.substring(0, 2);
		mes = fechaFinal.substring(2, 4);
		ano = fechaFinal.substring(4, 8);
		fechaFinal = dia + "/" + mes + "/" + ano;

		List<ACResultado> acResultados = ripsDAO.obtenerAC(contratoId, factura, fechaInicial, fechaFinal);

		CSVWriter csvWriter = new CSVWriter(new FileWriter(GeneralConstants.UPLOAD_FOLDER + "AC.csv"),
				CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
				CSVWriter.DEFAULT_LINE_END);

		String[] encabezado = { "#FACTURA", "PRESTADOR", "TIPO ID", "#DOC", "F.CONSULTA", "#AUTORIZACION",
				"COD CONSULTA", "FINALIDAD", "CAUSA EXTERNA", "DX PPAL", "DX REL1", "DX REL2", "DX REL3", "TIPO DX",
				"VL CONSULTA", "VL CUOTA MODERADORA", "VL NETO PAGAR" };

		csvWriter.writeNext(encabezado);

		for (ACResultado acResultado : acResultados) {
			String[] datos = acResultado.getStringArray();
			csvWriter.writeNext(datos);
		}
		csvWriter.close();

		File acFile = new File(GeneralConstants.UPLOAD_FOLDER + "AC.csv");

		return acFile;
	}

}
