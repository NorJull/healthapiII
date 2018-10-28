package com.vamosaprogramar.umedicalapi.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Process;

@Repository
public class ProcessDAOImpl implements ProcessDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Process> getProcesses() {
		Session session = null;

		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("From Process");

			List<Process> processes = theQuery.list();

			return processes;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return null;
	}

	@Override
	public Integer addProcess(Process process) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Integer processId = (Integer) session.save(process);

			process.setDescription(process.getDescription() + processId);

			session.getTransaction().commit();

			return processId;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return null;
	}

	@Override
	public void setLog(int ProcessId, String log) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Process process = session.get(Process.class, ProcessId);

			process.setLog(log);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public void setPercent(int processId, int currentRow, double percent) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Process process = session.get(Process.class, processId);

			process.setCurrentRow(currentRow);
			process.setPercent(percent);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public void setStatus(int processId, char status) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Process process = session.get(Process.class, processId);

			process.setStatus(status);
			;

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public void setFinishDate(int processId, LocalDateTime finishDate) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Process process = session.get(Process.class, processId);

			process.setFinishDateTime(finishDate);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public String getLog(int processId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query theQuery = session.createQuery("Select log From Process where id=:processId");

			theQuery.setParameter("processId", processId);

			String log = (String) theQuery.uniqueResult();

			session.getTransaction().commit();

			return log;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return null;
	}

	@Override
	public Process getProcess(int processId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Process process = session.get(Process.class, processId);

			session.getTransaction().commit();

			return process;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return null;
	}

	@Override
	public void deleteProcess(int processId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Process process = session.get(Process.class, processId);

			session.delete(process);
			
			session.getTransaction().commit();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}


		
	}

}
