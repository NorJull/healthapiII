package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenado;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.result.APResultado;
@Repository
public class ProcedimientoOrdenadoDAOImple implements ProcedimientoOrdenadoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void crearProcedimientoOrdenado(ProcedimientoOrdenado procedimientosOrdenado,
			Integer registroHistoriaClinicaId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			RegistroHistoriaClinica registroHistoriaClinica = session.get(RegistroHistoriaClinica.class,registroHistoriaClinicaId);

			procedimientosOrdenado.setRegistroHistoriaClinica(registroHistoriaClinica);
			
			session.save(procedimientosOrdenado);
			
			session.getTransaction().commit();
		}  catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}

	}


	@Override
	public List<ProcedimientoOrdenado> obtenerProcedimientosOrdenados(int pacienteId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("SELECT \r\n" + 
					"po.id AS \"id\", \r\n" + 
					"po.ambito_realizacion AS \"ambitoRealizacion\",\r\n" + 
					"po.codigo_diagnostico_principal AS \"codigoDiagnosticoPrincipal\",\r\n" + 
					"po.codigo_diagnostico_relacionado AS \"codigoDiagnosticoRelacionado\",\r\n" + 
					"po.cup AS \"cup\",\r\n" + 
					"po.fecha AS \"fecha\",\r\n" + 
					"po.finalidad AS \"finalidad\",\r\n" + 
					"po.numero_autorizacion AS \"numeroAutorizacion\",\r\n" + 
					"po.url_resultados AS \"urlResultados\"\r\n" + 
					"FROM public.procedimiento_ordenado AS po, public.registro_historia_clinica AS rhc\r\n" + 
					"WHERE \r\n" + 
					"rhc.paciente_id = :paciente AND\r\n" + 
					"po.registro_historia_clinica_id = rhc.id AND\r\n" + 
					"po.fue_ejecutado = \"O\"\r\n" + 
					"UNION ALL\r\n" + 
					"SELECT \r\n" + 
					"poa.id AS \"id\", \r\n" + 
					"poa.ambito_realizacion AS \"ambitoRealizacion\",\r\n" + 
					"poa.codigo_diagnostico_principal AS \"codigoDiagnosticoPrincipal\",\r\n" + 
					"poa.codigo_diagnostico_relacionado AS \"codigoDiagnosticoRelacionado\",\r\n" + 
					"poa.cup AS \"cup\",\r\n" + 
					"poa.fecha AS \"fecha\",\r\n" + 
					"poa.finalidad AS \"finalidad\",\r\n" + 
					"poa.numero_autorizacion AS \"numeroAutorizacion\",\r\n" + 
					"poa.url_resultados AS \"urlResultados\"\r\n" + 
					"FROM public.procedimiento_ordenado_aiepi AS poa, public.registro_aiepi AS ra\r\n" + 
					"WHERE \r\n" + 
					"ra.paciente_id = :paciente AND\r\n" + 
					"poa.registro_aiepi_id = ra.id AND\r\n" + 
					"poa.fue_ejecutado = \"O\"\r\n" + 
					"UNION ALL\r\n" + 
					"SELECT \r\n" + 
					"poo.id AS \"id\", \r\n" + 
					"poo.ambito_realizacion AS \"ambitoRealizacion\",\r\n" + 
					"poo.codigo_diagnostico_principal AS \"codigoDiagnosticoPrincipal\",\r\n" + 
					"poo.codigo_diagnostico_relacionado AS \"codigoDiagnosticoRelacionado\",\r\n" + 
					"poo.cup AS \"cup\",\r\n" + 
					"poo.fecha AS \"fecha\",\r\n" + 
					"poo.finalidad AS \"finalidad\",\r\n" + 
					"poo.numero_autorizacion AS \"numeroAutorizacion\",\r\n" + 
					"poo.url_resultados AS \"urlResultados\"\r\n" + 
					"FROM public.procedimiento_ordenado_odontologia AS poo, public.registro_odontologia AS ro\r\n" + 
					"WHERE \r\n" + 
					"ro.paciente_id = :paciente AND\r\n" + 
					"poo.registro_odontologia_id = ro.id AND\r\n" + 
					"poo.fue_ejecutado = \"O\"");
			
			sqlQuery.setParameter("paciente", pacienteId);
			sqlQuery.setResultTransformer(Transformers.aliasToBean(ProcedimientoOrdenado.class));
			
			List procedimientoOrdenado = sqlQuery.list();
			return procedimientoOrdenado;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		return null;
	}

}
