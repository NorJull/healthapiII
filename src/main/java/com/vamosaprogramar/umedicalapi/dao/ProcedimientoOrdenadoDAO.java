package com.vamosaprogramar.umedicalapi.dao;

import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenado;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;

public interface ProcedimientoOrdenadoDAO {

	void crearProcedimientoOrdenado(ProcedimientoOrdenado procedimientosOrdenado, Integer registroHistoriaClinicaId);

}
