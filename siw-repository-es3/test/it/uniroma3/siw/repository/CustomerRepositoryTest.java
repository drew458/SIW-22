package it.uniroma3.siw.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.siw.model.Address;
import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.Product;

class CustomerRepositoryTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	private static CustomerRepository customerRepository;
	private static Customer customer;
	
	@BeforeAll
	public static void initEntityManager() {
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
		customerRepository = new CustomerRepository();
		customerRepository.setEntityManager(em);
	}
	
	@BeforeEach
	public void cleanDb() {
		customer = new Customer();
		customer.setFirstName("Mario");
		customer.setLastName("Rossi");
		customer.setEmail("mariorossi@gmail.com");
		customer.setPhoneNumber("3404379247");
		customer.setDateOfBirth(LocalDate.of(1984, 01, 01));
		customer.setRegistrationDate(LocalDate.now());
		customer.setAddress(new Address(null, "Via del corso", "Roma", "Italia", "00121", "Lazio"));
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
		em.persist(customer);
		tx.commit();
		assertNotNull(customer.getId());
	}
	
	@Test
	void testFindByName() {
		assertEquals("Mario", customerRepository.findByName("Mario").get(0));
	}

}
