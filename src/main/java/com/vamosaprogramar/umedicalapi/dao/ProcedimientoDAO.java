package com.vamosaprogramar.umedicalapi.dao;

import com.vamosaprogramar.umedicalapi.entity.Procedimiento;

public interface ProcedimientoDAO {

	void crearProcedimiento(Procedimiento procedimiento, Integer registroHistoriaClinicaId);

}
