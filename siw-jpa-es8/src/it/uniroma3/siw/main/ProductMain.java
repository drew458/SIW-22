package it.uniroma3.siw.main;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.siw.model.Product;

public class ProductMain {

	public static void main(String[] args) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Scanner scanner;
		
		Product p1 = new Product("500", 14999.99f, "compatta", "0001");
		Product p2 = new Product("500X", 19999.99f, "SUV", "0002");
		Product p3 = new Product("Tipo", 18000.00f, "berlina", "0003");
		Product p4 = new Product("Fullback", 27000.00f, "pick-up", "0004");
		Product p5 = new Product("Ducato", 29990.00f, "furgone", "0005");
		
		tx.begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		tx.commit();
		
		TypedQuery<Product> query = em.createQuery
				("SELECT p FROM Product p WHERE p.price < :price", Product.class);
		System.out.println("Inserire il prezzo massimo del prodotto:");
		scanner = new Scanner(System.in);
		float inputPrice = scanner.nextFloat();
		scanner.close();
		query.setParameter("price", inputPrice);
		List<Product> products = query.getResultList();
		
		if(!products.isEmpty()) {
			System.out.println("I seguenti prodotti hanno prezzo minore di "+inputPrice+" :");
			for(Product p : products) {
				System.out.println(p.getName());
			}
		}
		else {
			System.out.println("Nessun prodotto ha un mezzo minore di "+inputPrice);
		}
	}
}
