package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.siw.model.Corso;

public class SchoolMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-unit");
		EntityManager em = emf.createEntityManager();

		Corso corso = new Corso();
		corso.setNome("matematica");
		corso.setMesiDurata(6);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(corso);
		tx.commit();

		em.close();
		emf.close();

	}
}