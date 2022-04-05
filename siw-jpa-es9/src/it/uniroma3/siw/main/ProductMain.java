package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.siw.model.Product;

public class ProductMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("product-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Product p1 = new Product("500", 15000.0f, "utilitaria", "0001");
		Product p2 = new Product("500X", 20000f, "SUV", "0002");
		Product p3 = new Product("Tipo", 18000f, "berlina", "0003");
		Product p4 = new Product("Fullback", 30000f, "pick-up", "0004");
		Product p5 = new Product("Ducato", 30000f, "furgone", "0005");
		Product p6 = new Product("911", 110000.0f, "sportiva", "0006");
		Product p7 = new Product("Taycan", 80000f, "elettrica", "0007");
		Product p8 = new Product("Panamera", 76000f, "berlina", "0008");
		Product p9 = new Product("Macan", 67000f, "SUV", "0009");
		Product p10 = new Product("Cayenne", 76000f, "SUV", "0010");
		
		tx.begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		em.persist(p6);
		em.persist(p7);
		em.persist(p8);
		em.persist(p9);
		em.persist(p10);
		tx.commit();
		
		TypedQuery<Product> 
	}
}
