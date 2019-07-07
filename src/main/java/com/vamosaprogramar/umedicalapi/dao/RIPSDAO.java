package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.result.ACResultado;
import com.vamosaprogramar.umedicalapi.entity.result.APResultado;

public interface RIPSDAO {
	
	public List<APResultado> obtenerAP(Integer contratoId,String factura, String fechaInicial, String fechaFinal);
	
	public List<ACResultado> obtenerAC(Integer contratoId,String factura, String fechaInicial, String fechaFinal);
}
