package it.uniroma3.siw.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	private static Product P1; 
	private static Product P2;

	@BeforeAll
	public static void initEntityManagerAndProducts() throws Exception {
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
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
	public void testDynamicQuery() throws Exception {		
		// Selezione
		TypedQuery<String> queryFindProductByName = em.createQuery("SELECT p.name FROM Product p WHERE p.name='golf'", String.class);
		List<String> products = queryFindProductByName.getResultList();
		assertFalse(products.isEmpty());
		assertEquals(1, products.size());
		assertEquals(P1.getName(), products.get(0));

		// Cancellazione
		Query queryDeleteProductByName = em.createQuery("DELETE FROM Product p WHERE p.name='polo'");
		tx.begin();
		int deletedProducts = queryDeleteProductByName.executeUpdate();
		tx.commit();
		assertTrue(deletedProducts!=0);
		assertEquals(1, deletedProducts);		
	}

	@Test
	public void testNamedQuery() throws Exception {
		// Selezione
		TypedQuery<Product> queryFindAllProducts = em.createNamedQuery("findAllProducts", Product.class);
		List<Product> products = queryFindAllProducts.getResultList();
		assertFalse(products.isEmpty());
		assertEquals(2, products.size());

		// Cancellazione
		Query queryDeleteAllProducts = em.createNamedQuery("deleteAllProducts");
		tx.begin();
		int deletedProducts = queryDeleteAllProducts.executeUpdate();
		tx.commit();
		assertEquals(2, deletedProducts);		
	}

	@Test
	public void testNativeQuery() throws Exception {		
		// Selezione
		Query queryFindProductByName = em.createNativeQuery("SELECT * FROM product WHERE name='golf'", Product.class);
		@SuppressWarnings("unchecked")
		List<Product> products = queryFindProductByName.getResultList();
		assertFalse(products.isEmpty());
		assertEquals(P1.getName(), products.get(0).getName());

		// Cancellazione
		Query queryDeleteProductByName = em.createNativeQuery("DELETE FROM product WHERE name='polo'");
		tx.begin();
		int deletedProducts = queryDeleteProductByName.executeUpdate();
		tx.commit();
		assertTrue(deletedProducts!=0);
		assertEquals(1, deletedProducts);
	}

}
