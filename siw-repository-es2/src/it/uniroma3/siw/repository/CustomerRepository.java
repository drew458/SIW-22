package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.Address;
import it.uniroma3.siw.model.Customer;

public class CustomerRepository {

	private EntityManager em;

	public Customer save(Customer customer) {
		if(customer.getId()!=null) {
			em.merge(customer);
		}
		else {
			em.persist(customer);
		}
		
		return customer;
	}
	
	public Customer findById(Long id) {
		return em.find(Customer.class, id);
	}
	
	public List<Customer> findAll(){
		return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
	}
	
	public void delete(Customer customer) {
		em.remove(customer);
	}
	
	public void deleteAll() {
		this.em.createQuery("DELETE FROM Customer").executeUpdate();
	}
	
	public long count() {
		return (Long)this.em.createQuery("SELECT Count(id) FROM Customer").getSingleResult();
	}
	
	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}
	
	public Address findCustomerAddress(Customer customer) {
		return em.find(Customer.class, customer.getId()).getAddress();
	}
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
