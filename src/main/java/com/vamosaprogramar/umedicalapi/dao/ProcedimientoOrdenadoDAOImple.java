package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenado;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenadoAIEPI;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenadoOdontologia;
import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;
import com.vamosaprogramar.umedicalapi.entity.result.APResultado;
@Repository
public class ProcedimientoOrdenadoDAOImple implements ProcedimientoOrdenadoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ProcedimientoOrdenado obtenerProcedimientoOrdenado(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			ProcedimientoOrdenado procedimientoOrdenado = session.get(ProcedimientoOrdenado.class, id);
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
	
	@Override
	public RegistroHistoriaClinica obtenerRegistroHistoriaClinica(int idProcedimientoOrdenado) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("select po.registroHistoriaClinica from ProcedimientoOrdenado po where po.id = :idProcedimientoOrdenado");
			query.setParameter("idProcedimientoOrdenado", idProcedimientoOrdenado);
			
			RegistroHistoriaClinica registroHistoriaClinica = (RegistroHistoriaClinica) query.uniqueResult();
			
			return registroHistoriaClinica;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		return null;
	}
	
	
	@Override
	public ProcedimientoOrdenadoOdontologia obtenerProcedimientoOrdenadoOdontologia(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			ProcedimientoOrdenadoOdontologia procedimientoOrdenadoOdontologia = session.get(ProcedimientoOrdenadoOdontologia.class, id);
			return procedimientoOrdenadoOdontologia;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		return null;
	}
	
	@Override
	public RegistroOdontologia obtenerRegistroOdontologia(int idProcedimientoOrdenadoOdontologia) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("select po.RegistroOdontologia from ProcedimientoOrdenadoOdontologia po where po.id = :idProcedimientoOrdenadoOdontologia");
			query.setParameter("idProcedimientoOrdenadoOdontologia", idProcedimientoOrdenadoOdontologia);
			
			RegistroOdontologia registroOdontologia = (RegistroOdontologia) query.uniqueResult();
			
			return registroOdontologia;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		return null;
	}
	
	@Override
	public ProcedimientoOrdenadoAIEPI obtenerProcedimientoOrdenadoAIEPI(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			ProcedimientoOrdenadoAIEPI procedimientoOrdenadoAIEPI= session.get(ProcedimientoOrdenadoAIEPI.class, id);
			return procedimientoOrdenadoAIEPI;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		return null;
	}
	
	@Override
	public RegistroAIEPI obtenerRegistroAIEPI(int idProcedimientoOrdenadoAIEPI) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("select po.registroAIEPI from ProcedimientoOrdenadoAIEPI po where po.id = :idProcedimientoOrdenadoAIEPI");
			query.setParameter("idProcedimientoOrdenadoAIEPI", idProcedimientoOrdenadoAIEPI);
			
			RegistroAIEPI registroAIEPI = (RegistroAIEPI) query.uniqueResult();
			
			return registroAIEPI;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		return null;
	}
	
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
					"po.fue_ejecutado = 'O'\r\n" + 
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
					"poa.fue_ejecutado = 'O'\r\n" + 
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
					"poo.fue_ejecutado = 'O'");
			
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

	@Override
	public void cambiarEstadoURLProcedimientoOrdenado(int procedimientoOrdenadoId, String ejecutado,
			String pathString) {
		
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("from ProcedimientoOrdenado where id = :procedimientoOrdenadoId");
			
			query.setParameter("procedimientoOrdenadoId", procedimientoOrdenadoId);
			
		    ProcedimientoOrdenado procedimientoOrdenado = (ProcedimientoOrdenado) query.uniqueResult();
		    
		    procedimientoOrdenado.setFueEjecutado(ejecutado);
		    
		    procedimientoOrdenado.setUrlResultados(pathString);
		    
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
	public void cambiarEstadoURLProcedimientoOrdenadoOdontologia(int procedimientoOrdenadoId, String ejecutado,
			String pathString) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("from ProcedimientoOrdenadoOdontologia where id = :procedimientoOrdenadoId");
			
			query.setParameter("procedimientoOrdenadoId", procedimientoOrdenadoId);
			
		    ProcedimientoOrdenadoOdontologia procedimientoOrdenadoOdontologia = (ProcedimientoOrdenadoOdontologia) query.uniqueResult();
		    
		    procedimientoOrdenadoOdontologia.setFueEjecutado(ejecutado);
		    
		    procedimientoOrdenadoOdontologia.setUrlResultados(pathString);
		    
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
	public void cambiarEstadoURLProcedimientoOrdenadoAIEPI(int procedimientoOrdenadoId, String ejecutado,
			String pathString) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("from ProcedimientoOrdenadoAIEPI where id = :procedimientoOrdenadoId");
			
			query.setParameter("procedimientoOrdenadoId", procedimientoOrdenadoId);
			
		    ProcedimientoOrdenadoAIEPI procedimientoOrdenadoAIEPI = (ProcedimientoOrdenadoAIEPI) query.uniqueResult();
		    
		    procedimientoOrdenadoAIEPI.setFueEjecutado(ejecutado);
		    
		    procedimientoOrdenadoAIEPI.setUrlResultados(pathString);
		    
			session.getTransaction().commit();
		}  catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
	}

}
