package com.classes;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.utils.JpaUtil;

public class EventoDAO extends JpaUtil {
	
	public EntityManagerFactory emf = getEntityManagerFactory();
	
	public EntityManager em = emf.createEntityManager();
	
	public void salvaEvento(Evento e) throws SQLException {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.refresh(e);
        System.out.println(e);
    }
	
	public Evento leggiDettaglioEvento(long id) throws SQLException {
        em.getTransaction().begin();
        Evento e = em.find(Evento.class, id);
        em.getTransaction().commit();
        return e;
	}
	
	public void cancellaEvento(long id) throws SQLException {
        em.getTransaction().begin();
        Evento e = em.find(Evento.class, id);
        em.remove(e);
        em.getTransaction().commit();
        System.out.println(e.getTitle() + " " + e.getEventType() + " deleted!!!");
    }
    
	
}
