package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.exception.DuplicateProcedureType;

public interface TipoProcedimientoDAO {

	public void crearTipoProcedimiento(TipoProcedimiento tipoProcedimiento);

	public List<TipoProcedimiento> getTiposProcedimientos();

	public TipoProcedimiento getTipoProcedimiento(int id);

	public void actualizarTipoProcedimiento(TipoProcedimiento tipoProcedimiento, int id);

	public void crearTipoProcedimiento(TipoProcedimiento tipoProcedimiento, Session session) throws DuplicateProcedureType;

	public List<TipoProcedimiento> getTiposProcedimientos(String codigoConcepto, String genero);

	public List<TipoProcedimiento> getTiposProcedimientos(String codigoConcepto);
	
}
