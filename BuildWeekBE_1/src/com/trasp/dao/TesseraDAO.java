package com.trasp.dao;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trasp.model.titoli.Tessera;
import com.trasp.model.titoli.Utente;
import com.trasp.util.JpaUtil;

public class TesseraDAO {
	
	private static Scanner scan = new Scanner(System.in);
	private static final Logger log = LoggerFactory.getLogger(TesseraDAO.class);

	public static void emissioneTessera() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Utente u = new Utente();
			System.out.println("Inserisci nome: ");
			String name = scan.nextLine();
			u.setNome(name);
			System.out.println("Inserisci cognome: ");
			String cognome = scan.nextLine();
			u.setCognome(cognome);
			Utente uD = UtenteDAO.saveUtente(u);
			Tessera t = new Tessera();
			t.setUtente(uD);
			em.persist(t);
			em.getTransaction().commit();
			
			log.info("Tessera emessa, Numero: " + t.getNumeroTessera());
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
		
		
	}

	public static Tessera findTessera(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tessera t = em.find(Tessera.class, id);
			em.getTransaction().commit();
			log.info("Rivenditore aggiunto!!!");
			return t;
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}

	public static void rinnovaTessera(long nTessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tessera t = em.find(Tessera.class, nTessera);
			if(t.getDatadiScadenza().isBefore(LocalDate.now())) {
				log.info("Tessera rinnovata!!!");
				t.setDatadiScadenza(t.getDatadiScadenza().plusYears(1));
				em.merge(t);
			}else {
				log.info("Tessera ancora valida!!!");
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}

	public static boolean checkTessera(long nTessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tessera t = em.find(Tessera.class, nTessera);
			if(t.getDatadiScadenza().isBefore(LocalDate.now())) {
				log.info("Tessera da rinnovare!!!");
				em.getTransaction().commit();
				return false;
			}else {
				log.info("Tessera ancora valida!!!");
				em.getTransaction().commit();
				return true;
			}
			
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}
}
