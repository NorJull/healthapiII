package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.result.ACResultado;
import com.vamosaprogramar.umedicalapi.entity.result.APResultado;
import com.vamosaprogramar.umedicalapi.entity.result.USResultado;


@Repository
public class RIPSDAOImpl implements RIPSDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<APResultado> obtenerAP(Integer contratoId, String factura, String fechaInicial, String fechaFinal) {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("SELECT\r\n" + 
					"	:factura as \"factura\",\r\n" + 
					"	health_entity.reps as \"prestador\",\r\n" + 
					"	registro_historia_clinica.tipo_identificacion as \"tipoDocumentoPaciente\",\r\n" + 
					"	registro_historia_clinica.documento as \"documentoPaciente\",\r\n" + 
					"	registro_historia_clinica.fecha_entrada as \"fechaProcedimiento\",\r\n" + 
					"	'' as \"numeroAutorizacion\", \r\n" + 
					"	procedimiento.cup as \"codigoProcedimiento\",\r\n" + 
					"	procedimiento.ambito_realizacion as \"ambitoRealizacionProcedimiento\",\r\n" + 
					"	procedimiento.finalidad as \"finalidadProcedimiento\",\r\n" + 
					"	'' as \"personalAtiende\",\r\n" + 
					"	procedimiento.codigo_diagnostico_principal as \"diagnosticoPrincipal\",\r\n" + 
					"	procedimiento.codigo_diagnostico_relacionado as \"diagnosticoRelacionado\",\r\n" + 
					"	procedimiento.codigo_diagnostico_complicacion as \"codigoDiagnosticoComplicacion\",\r\n" + 
					"	procedimiento.forma_realizacion as \"formaRealizacionActoQuirurjico\",\r\n" + 
					"	procedimiento.valor as \"valorProcedimiento\" \r\n" + 
					"FROM\r\n" + 
					"	registro_historia_clinica, procedimiento, contrato, health_entity, tipo_procedimiento\r\n" + 
					"WHERE\r\n" + 
					"	registro_historia_clinica.contrato_id = :contrato\r\n" + 
					"AND registro_historia_clinica.fecha_entrada between to_date(:fechaInicial, 'MM/DD/YYYY')  AND  to_date(:fechaFinal, 'MM/DD/YYYY')\r\n" + 
					"AND registro_historia_clinica.id = procedimiento.registro_historia_clinica_id\r\n" + 
					"AND procedimiento.cup = tipo_procedimiento.cup\r\n" + 
					"AND tipo_procedimiento.codigo_concepto <> '01'\r\n" + 
					"AND registro_historia_clinica.contrato_id = contrato.id\r\n" + 
					"AND contrato.health_entity_id = health_entity.id\r\n" + 
					"\r\n" + 
					"UNION ALL\r\n" + 
					"\r\n" + 
					"SELECT\r\n" + 
					"	:factura as \"factura\",\r\n" + 
					"	health_entity.reps as \"prestador\",\r\n" + 
					"	registro_aiepi.tipo_identificacion as \"tipoDocumentoPaciente\",\r\n" + 
					"	registro_aiepi.documento as \"documentoPaciente\",\r\n" + 
					"	registro_aiepi.fecha_entrada as \"fechaProcedimiento\",\r\n" + 
					"	'' as \"numeroAutorizacion\", \r\n" + 
					"	procedimiento_aiepi.cup as \"codigoProcedimiento\",\r\n" + 
					"	procedimiento_aiepi.ambito_realizacion  as \"ambitoRealizacionProcedimiento\",\r\n" + 
					"	procedimiento_aiepi.finalidad as \"finalidadProcedimiento\",\r\n" + 
					"	'' as \"personalAtiende\",\r\n" + 
					"	procedimiento_aiepi.codigo_diagnostico_principal  as \"diagnosticoPrincipal\",\r\n" + 
					"	procedimiento_aiepi.codigo_diagnostico_relacionado as \"diagnosticoRelacionado\",\r\n" + 
					"	procedimiento_aiepi.codigo_diagnostico_complicacion as \"codigoDiagnosticoComplicacion\",\r\n" + 
					"	procedimiento_aiepi.forma_realizacion as \"formaRealizacionActoQuirurjico\",\r\n" + 
					"	procedimiento_aiepi.valor as \"valorProcedimiento\" \r\n" + 
					"FROM\r\n" + 
					"	registro_aiepi, procedimiento_aiepi, contrato, health_entity, tipo_procedimiento\r\n" + 
					"WHERE\r\n" + 
					"	registro_aiepi.contrato_id = :contrato\r\n" + 
					"AND registro_aiepi.fecha_entrada between to_date(:fechaInicial, 'MM/DD/YYYY')  AND  to_date(:fechaFinal, 'MM/DD/YYYY')\r\n" + 
					"AND registro_aiepi.id = procedimiento_aiepi.registro_aiepi_id\r\n" + 
					"AND procedimiento_aiepi.cup = tipo_procedimiento.cup\r\n" + 
					"AND tipo_procedimiento.codigo_concepto <> '01'\r\n" + 
					"AND registro_aiepi.contrato_id = contrato.id\r\n" + 
					"AND contrato.health_entity_id = health_entity.id\r\n" + 
					"\r\n" + 
					"UNION ALL\r\n" + 
					"\r\n" + 
					"SELECT\r\n" + 
					"	:factura as \"factura\",\r\n" + 
					"	health_entity.reps as \"prestador\",\r\n" + 
					"	registro_odontologia.tipo_identificacion as \"tipoDocumentoPaciente\",\r\n" + 
					"	registro_odontologia.documento as \"documentoPaciente\",\r\n" + 
					"	registro_odontologia.fecha_entrada as \"fechaProcedimiento\",\r\n" + 
					"	'' as \"numeroAutorizacion\", \r\n" + 
					"	procedimiento_odontologia.cup as \"codigoProcedimiento\",\r\n" + 
					"	procedimiento_odontologia.ambito_realizacion  as \"ambitoRealizacionProcedimiento\",\r\n" + 
					"	procedimiento_odontologia.finalidad as \"finalidadProcedimiento\",\r\n" + 
					"	'' as \"personalAtiende\",\r\n" + 
					"	procedimiento_odontologia.codigo_diagnostico_principal  as \"diagnosticoPrincipal\",\r\n" + 
					"	procedimiento_odontologia.codigo_diagnostico_relacionado as \"diagnosticoRelacionado\",\r\n" + 
					"	procedimiento_odontologia.codigo_diagnostico_complicacion as \"codigoDiagnosticoComplicacion\",\r\n" + 
					"	procedimiento_odontologia.forma_realizacion as \"formaRealizacionActoQuirurjico\",\r\n" + 
					"	procedimiento_odontologia.valor as \"valorProcedimiento\" \r\n" + 
					"FROM\r\n" + 
					"	registro_odontologia, procedimiento_odontologia, contrato, health_entity, tipo_procedimiento\r\n" + 
					"WHERE\r\n" + 
					"	registro_odontologia.contrato_id = :contrato\r\n" + 
					"AND registro_odontologia.fecha_entrada between to_date(:fechaInicial, 'MM/DD/YYYY')  AND  to_date(:fechaFinal, 'MM/DD/YYYY') \r\n" + 
					"AND registro_odontologia.id = procedimiento_odontologia.registro_odontologia_id\r\n" + 
					"AND procedimiento_odontologia.cup = tipo_procedimiento.cup\r\n" + 
					"AND tipo_procedimiento.codigo_concepto <> '01'\r\n" + 
					"AND registro_odontologia.contrato_id = contrato.id\r\n" + 
					"AND contrato.health_entity_id = health_entity.id");
					
			sqlQuery.setParameter("factura", factura);
			sqlQuery.setParameter("contrato", contratoId);
			sqlQuery.setParameter("fechaInicial", fechaInicial);
			sqlQuery.setParameter("fechaFinal", fechaFinal);
			
			sqlQuery.setResultTransformer(Transformers.aliasToBean(APResultado.class));

			List APResultados = sqlQuery.list();
			
			return APResultados;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}
	@Override
	public List<ACResultado> obtenerAC(Integer contratoId, String factura, String fechaInicial, String fechaFinal) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("\r\n" + 
					"SELECT\r\n" + 
					"	:factura as \"numeroFactura\",\r\n" + 
					"	health_entity.reps as \"codigoPrestador\",\r\n" + 
					"	registro_historia_clinica.tipo_identificacion as \"tipoIdentificacionPaciente\",\r\n" + 
					"	registro_historia_clinica.documento as \"documento\",\r\n" + 
					"	registro_historia_clinica.fecha_entrada as \"fechaConsulta\",\r\n" + 
					"	'' as \"numeroAutorizacion\", \r\n" + 
					"	procedimiento.cup as \"codigoConsulta\",\r\n" + 
					"	procedimiento.finalidad as \"finalidad\",\r\n" + 
					"	registro_historia_clinica.causa_externa as \"causaExterna\",\r\n" + 
					"	registro_historia_clinica.codigo_diagnostico_principal as \"codigoDiagnosticoPrincipal\",\r\n" + 
					"	registro_historia_clinica.codigo_diagnostico_relacionado_1 as \"codigoDiagnosticoRelacionado1\",\r\n" + 
					"	registro_historia_clinica.codigo_diagnostico_relacionado_2 as \"codigoDiagnosticoRelacionado2\",\r\n" + 
					"	registro_historia_clinica.codigo_diagnostico_relacionado_3 as \"codigoDiagnosticoRelacionado3\",\r\n" + 
					"	registro_historia_clinica.tipo_diagnostico_principal as \"tipoDiagnosticoPrincipal\",\r\n" + 
					"	procedimiento.valor as \"valorConsulta\", \r\n" + 
					"	0 as \"valorCuotaModeradora\", \r\n" + 
					"	procedimiento.valor as \"valorNetoPagar\"\r\n" + 
					"FROM\r\n" + 
					"	registro_historia_clinica, procedimiento, tipo_procedimiento, contrato, health_entity\r\n" + 
					"WHERE\r\n" + 
					"	registro_historia_clinica.contrato_id = :contrato\r\n" + 
					"AND registro_historia_clinica.fecha_entrada between to_date(:fechaInicial, 'MM/DD/YYYY')  AND  to_date(:fechaFinal, 'MM/DD/YYYY')\r\n" + 
					"AND registro_historia_clinica.id = procedimiento.registro_historia_clinica_id\r\n" + 
					"AND procedimiento.cup = tipo_procedimiento.cup\r\n" + 
					"AND tipo_procedimiento.codigo_concepto = '01'\r\n" + 
					"AND registro_historia_clinica.contrato_id  = contrato.id\r\n" + 
					"AND contrato.health_entity_id = health_entity.id\r\n" + 
					"\r\n" + 
					"UNION ALL\r\n" + 
					"\r\n" + 
					"SELECT\r\n" + 
					"	:factura as \"numeroFactura\",\r\n" + 
					"	health_entity.reps as \"codigoPrestador\",\r\n" + 
					"	registro_aiepi.tipo_identificacion as \"tipoIdentificacionPaciente\",\r\n" + 
					"	registro_aiepi.documento as \"documento\",\r\n" + 
					"	registro_aiepi.fecha_entrada as \"fechaConsulta\",\r\n" + 
					"	'' as \"numeroAutorizacion\", \r\n" + 
					"	procedimiento_aiepi.cup as \"codigoConsulta\",\r\n" + 
					"	procedimiento_aiepi.finalidad as \"finalidad\",\r\n" + 
					"	registro_aiepi.causa_externa as \"causaExterna\",\r\n" + 
					"	registro_aiepi.codigo_diagnostico_principal as \"codigoDiagnosticoPrincipal\",\r\n" + 
					"	registro_aiepi.codigo_diagnostico_relacionado_1 as \"codigoDiagnosticoRelacionado1\",\r\n" + 
					"	registro_aiepi.codigo_diagnostico_relacionado_2 as \"codigoDiagnosticoRelacionado2\",\r\n" + 
					"	registro_aiepi.codigo_diagnostico_relacionado_3 as \"codigoDiagnosticoRelacionado3\",\r\n" + 
					"	registro_aiepi.tipo_diagnostico_principal as \"tipoDiagnosticoPrincipal\",\r\n" + 
					"	procedimiento_aiepi.valor as \"valorConsulta\", \r\n" + 
					"	0 as \"valorCuotaModeradora\",\r\n" + 
					"	procedimiento_aiepi.valor as \"valorNetoPagar\"\r\n" + 
					"FROM\r\n" + 
					"	registro_aiepi, procedimiento_aiepi, tipo_procedimiento, contrato, health_entity\r\n" + 
					"WHERE\r\n" + 
					"	registro_aiepi.contrato_id = :contrato\r\n" + 
					"AND registro_aiepi.fecha_entrada between to_date(:fechaInicial, 'MM/DD/YYYY')  AND  to_date(:fechaFinal, 'MM/DD/YYYY')\r\n" + 
					"AND registro_aiepi.id = procedimiento_aiepi.registro_aiepi_id\r\n" + 
					"AND procedimiento_aiepi.cup = tipo_procedimiento.cup\r\n" + 
					"AND tipo_procedimiento.codigo_concepto = '01'\r\n" + 
					"AND registro_aiepi.contrato_id = contrato.id\r\n" + 
					"AND contrato.health_entity_id = health_entity.id\r\n" + 
					"\r\n" + 
					"UNION ALL\r\n" + 
					"\r\n" + 
					"SELECT\r\n" + 
					"	:factura as \"numeroFactura\",\r\n" + 
					"	health_entity.reps as \"codigoPrestador\",\r\n" + 
					"	registro_odontologia.tipo_identificacion as \"tipoIdentificacionPaciente\",\r\n" + 
					"	registro_odontologia.documento as \"documento\",\r\n" + 
					"	registro_odontologia.fecha_entrada as \"fechaConsulta\",\r\n" + 
					"	'' as \"numeroAutorizacion\", \r\n" + 
					"	procedimiento_odontologia.cup as \"codigoConsulta\",\r\n" + 
					"	procedimiento_odontologia.finalidad as \"finalidad\",\r\n" + 
					"	registro_odontologia.causa_externa as \"causaExterna\",\r\n" + 
					"	registro_odontologia.codigo_diagnostico_principal as \"codigoDiagnosticoPrincipal\",\r\n" + 
					"	registro_odontologia.codigo_diagnostico_relacionado_1 as \"codigoDiagnosticoRelacionado1\",\r\n" + 
					"	registro_odontologia.codigo_diagnostico_relacionado_2 as \"codigoDiagnosticoRelacionado2\",\r\n" + 
					"	registro_odontologia.codigo_diagnostico_relacionado_3 as \"codigoDiagnosticoRelacionado3\",\r\n" + 
					"	registro_odontologia.tipo_diagnostico_principal as \"tipoDiagnosticoPrincipal\",\r\n" + 
					"	procedimiento_odontologia.valor as \"valorConsulta\", \r\n" + 
					"	0 as \"valorCuotaModeradora\", \r\n" + 
					"	procedimiento_odontologia.valor as \"valorNetoPagar\"\r\n" + 
					"FROM\r\n" + 
					"	registro_odontologia, procedimiento_odontologia, tipo_procedimiento, contrato, health_entity\r\n" + 
					"WHERE\r\n" + 
					"	registro_odontologia.contrato_id = :contrato\r\n" + 
					"AND registro_odontologia.fecha_entrada between to_date(:fechaInicial, 'MM/DD/YYYY')  AND  to_date(:fechaFinal, 'MM/DD/YYYY')\r\n" + 
					"AND registro_odontologia.id = procedimiento_odontologia.registro_odontologia_id\r\n" + 
					"AND procedimiento_odontologia.cup = tipo_procedimiento.cup\r\n" + 
					"AND tipo_procedimiento.codigo_concepto = '01'\r\n" + 
					"AND registro_odontologia.contrato_id = contrato.id\r\n" + 
					"AND contrato.health_entity_id = health_entity.id");
			
			sqlQuery.setParameter("factura", factura);
			sqlQuery.setParameter("contrato", contratoId);
			sqlQuery.setParameter("fechaInicial", fechaInicial);
			sqlQuery.setParameter("fechaFinal", fechaFinal);
			
			sqlQuery.setResultTransformer(Transformers.aliasToBean(ACResultado.class));
			
			List acResultados =  sqlQuery.list();			
			
			return acResultados;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}
	@Override
	public List<USResultado> obtenerUS(Integer contratoId) {
		Session session = null;
		try {

			session = sessionFactory.openSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("select \r\n" + 
					"patient.document_type as \"tipoDocumento\",\r\n" + 
					"patient.document as \"documento\",\r\n" + 
					"health_entity.reps as \"prestador\", \r\n" + 
					"'2' as \"tipoUsuario\",\r\n" + 
					"patient.last_name_1 as \"primerApellido\",\r\n" + 
					"patient.last_name_2 as \"segundoApellido\",\r\n" + 
					"patient.name_1 as \"primerNombre\",\r\n" + 
					"patient.name_2 as \"segundoNombre\",\r\n" + 
					"patient.age as \"edad\", \r\n" + 
					"'1' as \"unidadMedidaEdad\",\r\n" + 
					"patient.gender as \"sexo\",\r\n" + 
					"patient.departament_id as \"departamento\",\r\n" + 
					"patient.town_id as \"municipio\",\r\n" + 
					"patient.zone as \"zona\"\r\n" + 
					"from patient, contrato, health_entity\r\n" + 
					"where\r\n" + 
					"patient.contract_id = :contrato and \r\n" + 
					"contrato.id = :contrato and \r\n" + 
					"contrato.health_entity_id = health_entity.id");
			
			sqlQuery.setParameter("contrato", contratoId);
			
			sqlQuery.setResultTransformer(Transformers.aliasToBean(USResultado.class));
			
			List usResultados = sqlQuery.list();
			
			return usResultados;	
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

}
