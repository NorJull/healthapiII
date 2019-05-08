package com.vamosaprogramar.umedicalapi.dao;

import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.Remision;

public interface RemisionDAO {

	void crearRemision(Remision remision, Integer registroHistoriaClinicaId);

}
