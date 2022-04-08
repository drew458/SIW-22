package it.uniroma3.siw.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.siw.model.Product;

class ProductRepositoryTest {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	private static ProductRepository productRepository;
	private static Product P1; 
	private static Product P2;
	
	
	@BeforeAll
	public static void initEntityManager() {
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
		productRepository = new ProductRepository();
		productRepository.setEntityManager(em);
	}
	
	@BeforeEach
	public void cleanDb() {
		P1 = new Product("golf", 24999.99f, "5 porte", "0001");
		P2 = new Product("polo", 14999.9f, "3 porte", "0002");
		tx = em.getTransaction();
		
		// Inizializzazione DB
		Query deleteAllRows = em.createQuery("DELETE FROM Product p");
		tx.begin();
		deleteAllRows.executeUpdate();
		tx.commit();
		TypedQuery<Product> queryFindAllProducts = em.createNamedQuery("findAllProducts", Product.class);
		assertTrue(queryFindAllProducts.getResultList().isEmpty());

		// Inserimento
		tx.begin();
		em.persist(P1);
		em.persist(P2);
		tx.commit();
		assertNotNull(P1.getId());
	}
	
	@AfterAll
	public static void closeEntityManager() throws SQLException{
		if (em != null) em.close();
		if (em != null) emf.close();
	}

	@Test
	public void testFindAll() {
		assertEquals(2, productRepository.findAll().size());
	}
	
	@Test
	public void testDelete() {
		TypedQuery<Product> getAllProductsQuery = em.createQuery("SELECT p FROM Product p", Product.class);
		assertEquals(2, getAllProductsQuery.getResultList().size());
		tx.begin();
		productRepository.delete(P1);
		tx.commit();
		assertEquals(1, getAllProductsQuery.getResultList().size());
	}
	
	@Test
	public void testDeleteAll() {
		TypedQuery<Product> getAllProductsQuery = em.createQuery("SELECT p FROM Product p", Product.class);
		assertEquals(2, getAllProductsQuery.getResultList().size());
		tx.begin();
		productRepository.deleteAll();
		tx.commit();
		assertEquals(0, getAllProductsQuery.getResultList().size());
	}
	
	@Test
	public void testCount() {
		assertEquals(2, productRepository.count());
	}

}
