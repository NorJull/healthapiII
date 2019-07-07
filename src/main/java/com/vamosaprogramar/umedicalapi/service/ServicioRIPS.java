package com.vamosaprogramar.umedicalapi.service;

import java.io.File;
import java.io.IOException;

public interface ServicioRIPS {
	public File obtenerAP(Integer contratoId, String factura, String fechaInicial, String fechaFinal) throws IOException;
	public File obtenerAC(Integer contratoId, String factura, String fechaInicial, String fechaFinal) throws IOException;

}
