package it.uniroma3.siw.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	
	@BeforeAll
	public static void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
	}
	
	@BeforeEach
	public void initTransaction() {
		tx = em.getTransaction();
	}
	
	@AfterAll
	public static void closeEntityManager() throws SQLException{
		if (em != null) em.close();
		if (emf != null) emf.close();
	}
	
	
	@Test
	public void shouldCreateAddress() throws Exception {
		Provider provider = new Provider();
		Address address = new Address();
		address.setCity("Rome");
		address.setCountry("Italy");
		address.setState("Lazio");
		address.setStreet("Via del Governo Vecchio");
		address.setZipcode("00121");
		provider.setName("vodafone");
		provider.setPhoneNumber("0606060606");
		provider.setEmail("info@vodafone.com");
		provider.setAddress(address);
		assertNull("ID prima del commit dovrebbe essere nullo", address.getId());
		tx.begin();
		em.persist(provider);
		tx.commit();
		assertNotNull("ID dopo il commit non dovrebbe essere nullo", address.getId());
	}

}
