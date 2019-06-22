package com.vamosaprogramar.umedicalapi.dao;

import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroOdontologiaResult;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistroOdontologiaDAOImpl implements RegistroOdontologiaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<RegistroOdontologiaResult> obtenerRegistroOdontologiaResultPorPaciente(int patientId) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            Query theQuery = session.createQuery(
              "select mr.id as id, mr.pacienteId as pacienteId, mr.fechaEntrada as fecha, mr.horaEntrada as hora, mr.motivoConsulta as motivoConsulta from RegistroOdontologia mr where mr.pacienteId = :pacienteId");
            theQuery.setParameter("pacienteId", patientId);

            theQuery.setResultTransformer(Transformers.aliasToBean(RegistroOdontologiaResult.class));

            List<RegistroOdontologiaResult> registroHistoriaClinicaResults = theQuery.list();

            return registroHistoriaClinicaResults;

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
    public Integer crearRegistroOdontologia(RegistroOdontologia registroOdontologia) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            Integer id = (Integer) session.save(registroOdontologia);

            session.getTransaction().commit();
            return id;
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
    public RegistroOdontologia obtenerRegistroOdontologia(int id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            RegistroOdontologia registroOdontologia = (RegistroOdontologia) session.get(RegistroOdontologia.class, id);

            return registroOdontologia;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return null;
    }
}
