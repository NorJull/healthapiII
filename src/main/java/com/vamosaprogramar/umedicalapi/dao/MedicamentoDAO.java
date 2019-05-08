package com.vamosaprogramar.umedicalapi.dao;

import com.vamosaprogramar.umedicalapi.entity.Medicamento;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;

public interface MedicamentoDAO {

	void crearMedicamento(Medicamento medicamento, Integer registroHistoriaClinicaId);

}
