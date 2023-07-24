package com.trasp.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trasp.model.titoli.Utente;
import com.trasp.util.JpaUtil;

public class UtenteDAO {

	private static final Logger log = LoggerFactory.getLogger(UtenteDAO.class);
	
	public static Utente saveUtente(Utente u) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			log.info("Utente aggiunto!!!");
			return u;
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}
	
}
