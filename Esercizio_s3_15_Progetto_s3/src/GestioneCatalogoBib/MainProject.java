package GestioneCatalogoBib;


import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.AnnotationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import model.ElementiB;
import model.Libri;
import model.Periodicità;
import model.Rivista;
import util.JpaUtil;

public class MainProject {

	private static final Logger logger = LoggerFactory.getLogger(MainProject.class);
	static EntityManager em = Persistence.createEntityManagerFactory("Esercizio_s3_15_Progetto_s3").createEntityManager();
	
	
	
	
	public static void main(String[] args) {
		
		
		
	}

	
	public static void generate() {
		Libri l1 = new Libri();
		l1.setTitolo("Dell'Elefante");
		l1.setAutore("La Torre");
		l1.setGenere("Drama");
		l1.setAnnoDiPubblicazione(LocalDate.of(20, 4, 1998));
		
	}
	
	public static void add(ElementiB e){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} catch (AnnotationException ex) {
			em.getTransaction().rollback();

			logger.error("Error saving object: " + e.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}
}
