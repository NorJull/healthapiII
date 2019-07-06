package com.vamosaprogramar.umedicalapi.dao;

import java.time.LocalDate;
import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.result.APResultado;

public interface RIPSDAO {
	
	public List<APResultado> obtenerAP(Integer contratoId,String factura, String fechaInicial, String fechaFinal);
}
