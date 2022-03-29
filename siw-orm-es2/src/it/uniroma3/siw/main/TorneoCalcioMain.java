package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TorneoCalcioMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("torneo-calcio-unit");
		EntityManager em = emf.createEntityManager();
		em.close();
		emf.close();
	}
}
