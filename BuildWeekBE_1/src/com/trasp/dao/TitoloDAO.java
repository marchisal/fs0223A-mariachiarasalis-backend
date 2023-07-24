package com.trasp.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trasp.enums.Durata;
import com.trasp.enums.StatodiServizio;
import com.trasp.model.rivenditori.DistributoreAutomatico;
import com.trasp.model.rivenditori.Rivenditore;
import com.trasp.model.rivenditori.RivenditoreAutorizzato;
import com.trasp.model.titoli.Abbonamento;
import com.trasp.model.titoli.Biglietto;
import com.trasp.model.titoli.Tessera;
import com.trasp.model.titoli.TitolodiViaggio;
import com.trasp.util.JpaUtil;

public class TitoloDAO {
	
	private static final Logger log = LoggerFactory.getLogger(TitoloDAO.class);
	private static Scanner scan = new Scanner(System.in);
	
	public static void emissioneBiglietto(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Rivenditore r = RivenditoreDAO.findRivenditore(id);
		
		if (r instanceof RivenditoreAutorizzato) {
			RivenditoreAutorizzato ra = (RivenditoreAutorizzato) r;
			LocalTime currentTime = LocalTime.now();
			// rivenditore autorizzato
			if (currentTime.isAfter(ra.getOrariodiApertura()) && currentTime.isBefore(ra.getOrariodiChiusura())) {
				try {
					em.getTransaction().begin();
					Biglietto b = new Biglietto();
					b.setLuogodiAcquisto(r);
					em.persist(b);
					em.getTransaction().commit();
					log.info("Biglietto acquistato!!!");
				} catch (Exception ex) {
					em.getTransaction().rollback();

					log.error(ex.getMessage());
					throw ex;

				} finally {
					em.close();
				}
			} else {
				log.info("Rivenditore chiuso!!!.");
			}
			// distributore automatico
		} else {
			try {
				em.getTransaction().begin();
				DistributoreAutomatico da = (DistributoreAutomatico) r;
				if(da.getStatus().equals(StatodiServizio.ATTIVO)) {
					Biglietto b = new Biglietto();
					b.setLuogodiAcquisto(r);
					em.persist(b);
					em.getTransaction().commit();
					log.info("Biglietto acquistato!!!");
				}else {
					log.info("Distributore Automatico Chiuso!!!");
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

	public static void caricaAbbonamento(long id, long nTessera, Durata durata) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			Rivenditore r = RivenditoreDAO.findRivenditore(id);
			Tessera t = em.find(Tessera.class, nTessera);
			em.getTransaction().begin();
			Abbonamento a = new Abbonamento();
			a.setTessera(t);
			a.setDurata(durata);
				switch(durata) {
				case SETTIMANALE:
					a.setDatadiScadenza(LocalDate.now().plusDays(7));
					break;
				case MENSILE:
					a.setDatadiScadenza(LocalDate.now().plusMonths(1));
					break;
				default:
					a.setDatadiScadenza(LocalDate.now());
				}
			a.setLuogodiAcquisto(r);
			Abbonamento aD = saveAbbonamento(a);
			t.setAbbonamento(aD);
			em.merge(t);
			em.getTransaction().commit();
			log.info("Abbonamento caricato!!!");
			}catch (Exception e) {
				em.getTransaction().rollback();
				log.error("Abbonamento non caricato" + e.getMessage());
				throw e;
			}finally{
				em.close();
			}

}

	private static Abbonamento saveAbbonamento(Abbonamento a) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			return a;
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}

}

	public static void rinnovaAbbonamento(long nTessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tessera t = em.find(Tessera.class, nTessera);
			if(t.getAbbonamento() == null) {
				log.info("Abbonamento non ancora caricato!!!");
			}else if(t.getAbbonamento().getDatadiScadenza().isBefore(LocalDate.now())){
				if(t.getAbbonamento().getDurata().equals(Durata.MENSILE)) {
					System.out.println("Premi 1 per rinnovare l'abbonamento MENSILE");
					System.out.println("Premi 2 per passare all'abbonamento SETTIMANALE");
					int a = scan.nextInt();
					switch(a) {
					case 1: 
						t.getAbbonamento().setDatadiScadenza(t.getAbbonamento().getDatadiScadenza().plusMonths(1));
						log.info("Abbonamento mensile rinnovato!!!");
						break;
					case 2: 
						t.getAbbonamento().setDurata(Durata.SETTIMANALE);
						t.getAbbonamento().setDatadiScadenza(t.getAbbonamento().getDatadiScadenza().plusDays(7));
						log.info("Rinnovo ad abbonamento settimanale!!!");
						break;
					}
				}else {
					System.out.println("Premi 1 per rinnovare l'abbonamento SETTIMANALE");
					System.out.println("Premi 2 per passare all'abbonamento MENSILE");
					int a = scan.nextInt();
					switch(a) {
					case 1: 
						t.getAbbonamento().setDatadiScadenza(t.getAbbonamento().getDatadiScadenza().plusDays(7));
						log.info("Abbonamento settimanale rinnovato!!!");
						break;
					case 2: 
						t.getAbbonamento().setDurata(Durata.MENSILE);
						t.getAbbonamento().setDatadiScadenza(t.getAbbonamento().getDatadiScadenza().plusMonths(1));
						log.info("Rinnovo ad abbonamento mensile!!!");
						break;
					}
				}
			}else {
				log.info("Abbonamento ancora valido!!!");
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

	public static boolean checkAbbonamento(long nTessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tessera t = em.find(Tessera.class, nTessera);
			if(t.getAbbonamento() == null) {
				log.info("Abbonamento non ancora caricato!!!");
				em.getTransaction().commit();
				return false;
			}else if(t.getAbbonamento().getDatadiScadenza().isBefore(LocalDate.now())){
					log.info("Abbonamento scaduto!!!");
					em.getTransaction().commit();
					return false;

			}else {
				log.info("Abbonamento ancora valido!!!");
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
	
	public static void findTitoliByRivenditore(long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
        Query query1 = em.createNamedQuery("findBigliettiByRivenditore", TitolodiViaggio.class);
        query1.setParameter("idRivenditore", id);
        List<TitolodiViaggio> risultato1 = query1.getResultList();

        Query query2 = em.createNamedQuery("findAbbonamentiByRivenditore", TitolodiViaggio.class);
        query2.setParameter("idRivenditore", id);
        List<TitolodiViaggio> risultato2 = query2.getResultList();

        List<TitolodiViaggio> risultatoFinale = new ArrayList<>();
        risultatoFinale.addAll(risultato1);
        risultatoFinale.addAll(risultato2);
        
        risultatoFinale.forEach(t -> log.info(t.toString()));
        
        if(risultatoFinale.size()==0) {
        	log.info("Nessun risultato presso il rivenditore indicato!!!");
        }
		}finally{
			em.close();
		}

	}

	public static void findTitoliByDate(LocalDate inizio, LocalDate fine) {
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
        Query query1 = em.createNamedQuery("findBigliettiByDate", TitolodiViaggio.class);
        query1.setParameter("inizio", inizio);
        query1.setParameter("fine", fine);
        List<TitolodiViaggio> risultato1 = query1.getResultList();

        Query query2 = em.createNamedQuery("findAbbonamentiByDate", TitolodiViaggio.class);
        query2.setParameter("inizio", inizio);
        query2.setParameter("fine", fine);
        List<TitolodiViaggio> risultato2 = query2.getResultList();

        List<TitolodiViaggio> risultatoFinale = new ArrayList<>();
        risultatoFinale.addAll(risultato1);
        risultatoFinale.addAll(risultato2);
        
        risultatoFinale.forEach(t -> log.info(t.toString()));
        if(risultatoFinale.size()==0) {
        	log.info("Nessun risultato nelle date indicate!!!");
        }
        
		}finally{
			em.close();
		}
	}
	
	public static void printAllTitoli() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
        Query query1 = em.createNamedQuery("printAllBiglietti", TitolodiViaggio.class);
        List<TitolodiViaggio> risultato = query1.getResultList();
        
        risultato.addAll(risultato);
        
        risultato.forEach(t -> log.info(t.toString()));
        if(risultato.size()==0) {
        	log.info("Nessun titolo creato!!!");
        }
        
		}finally{
			em.close();
		}
	}
}
