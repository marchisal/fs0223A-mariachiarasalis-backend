package com.trasp.dao;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trasp.enums.StatodeiMezzi;
import com.trasp.model.mezzi.Manutenzione;
import com.trasp.model.mezzi.Mezzo;
import com.trasp.model.titoli.Biglietto;
import com.trasp.model.titoli.TitolodiViaggio;
import com.trasp.util.JpaUtil;

public class MezzoDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MezzoDAO.class);
	
	public static Mezzo saveMezzo(Mezzo m) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			return m;
		} catch (Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}

	public static void entrainManutenzione(long id) {
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Mezzo m = em.find(Mezzo.class, id);
			if(m.getStatomezzo() == StatodeiMezzi.INMANUTENZIONE) {
				log.info("Mezzo gia in manutenzione!!!");
			}else {
				m.setStatomezzo(StatodeiMezzi.INMANUTENZIONE);
				Manutenzione mu = new Manutenzione();
				mu.setInizioManutenzione(LocalDate.now());
				em.persist(mu);
				m.getPeriodoDiManutenzione().add(mu);
				em.merge(m);
				log.info("Mezzo entrato in manutenzione!!!");
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
	
	public static void  entrainServizio(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Mezzo m = em.find(Mezzo.class, id);
			if(m.getStatomezzo() == StatodeiMezzi.INSERVIZIO) {
				log.info("Mezzo gia in servizio!!!");
			}else {
				m.setStatomezzo(StatodeiMezzi.INSERVIZIO);
				long idm = m.getPeriodoDiManutenzione().get(m.getPeriodoDiManutenzione().size()-1).getId();
				Manutenzione mu = em.find(Manutenzione.class, idm);
				mu.setFineManutenzione(LocalDate.now());
				em.merge(mu);
				m.getPeriodoDiManutenzione().add(mu);
				em.merge(m);
				log.info("Mezzo entrato in servizio!!!");
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
	
	public static boolean checkStatoMezzo(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Mezzo m = em.find(Mezzo.class, id);
			if(m.getStatomezzo() == StatodeiMezzi.INMANUTENZIONE) {
				log.info("Mezzo in manutenzione!!!");
				em.getTransaction().commit();
				return false;
			}else {
				log.info("Mezzo in servizio!!!");
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
	
	public static void vidimaBiglietto(long idB, long idM) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Biglietto b = em.find(Biglietto.class, idB);
			if(b.isValid()) {
				b.setValid(false);
				Mezzo m = em.find(Mezzo.class, idM);
				b.setLuogodiValidazione(m);
				b.setDatadiValidazione(LocalDate.now());
				em.merge(b);
				log.info("Biglietto validato!!!");
			}else {
				log.info("Biglietto non valido!!!");
			}
			em.getTransaction().commit();
			log.info("Biglietto: " + b.toString());
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}
	
	public static void findBigliettiByMezzo(long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
        Query query = em.createNamedQuery("findBigliettiByMezzo", TitolodiViaggio.class);
        query.setParameter("idMezzo", id);
        List<Biglietto> risultato = query.getResultList();
        
        risultato.forEach(b -> log.info(b.toString()));
        
        if(risultato.size()==0) {
        	log.info("Nessun risultato presso il mezzo indicato!!!");
        }
		}finally{
			em.close();
		}

	}
	
	public static void findBigliettiByValidationDate(LocalDate inizio, LocalDate fine) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
        Query query = em.createNamedQuery("findBigliettiByValidationDate", TitolodiViaggio.class);
        query.setParameter("inizio", inizio);
        query.setParameter("fine", fine);
        List<Biglietto> risultato = query.getResultList();
        
        risultato.forEach(b -> log.info(b.toString()));
        
        if(risultato.size()==0) {
        	log.info("Nessun risultato presso la data indicata!!!");
        }
		}finally{
			em.close();
		}

	}

	public static void findManutenzioni(long id) {
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Mezzo m = em.find(Mezzo.class, id);
			if(m.getPeriodoDiManutenzione().size() == 0) {
				log.info("Mezzo nuovo di zecca!!!");
			}else {
				log.info("Manutenzioni del mezzo: ");
				Set<Manutenzione> risultato = new HashSet();
				m.getPeriodoDiManutenzione().forEach(p -> risultato.add(p));
				risultato.forEach(p -> {
					if(p.getFineManutenzione() == null) {
						log.info("Questa manutenzione è in corso: " + p.toString());
					}else {
						log.info("Manutenzione finita: " + p.toString());
					}
				});	
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

}
