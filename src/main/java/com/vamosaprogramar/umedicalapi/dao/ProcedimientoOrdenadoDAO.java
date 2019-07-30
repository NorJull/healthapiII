package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenado;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenadoAIEPI;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenadoOdontologia;
import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;

public interface ProcedimientoOrdenadoDAO {

	void crearProcedimientoOrdenado(ProcedimientoOrdenado procedimientosOrdenado, Integer registroHistoriaClinicaId);

	List<ProcedimientoOrdenado> obtenerProcedimientosOrdenados(int pacienteId);

	ProcedimientoOrdenado obtenerProcedimientoOrdenado(int id);

	ProcedimientoOrdenadoOdontologia obtenerProcedimientoOrdenadoOdontologia(int id);

	ProcedimientoOrdenadoAIEPI obtenerProcedimientoOrdenadoAIEPI(int id);

	RegistroHistoriaClinica obtenerRegistroHistoriaClinica(int idProcedimientoOrdenado);
	
	RegistroOdontologia obtenerRegistroOdontologia(int idProcedimientoOrdenadoOdontologia);

	RegistroAIEPI obtenerRegistroAIEPI(int idProcedimientoOrdenadoAIEPI);

	void cambiarEstadoURLProcedimientoOrdenado(int procedimientoOrdenadoId, String ejecutado, String pathString);

	void cambiarEstadoURLProcedimientoOrdenadoOdontologia(int procedimientoOrdenadoId, String ejecutado,
			String pathString);

	void cambiarEstadoURLProcedimientoOrdenadoAIEPI(int procedimientoOrdenadoId, String ejecutado, String pathString);
}
