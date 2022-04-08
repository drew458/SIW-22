package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import it.uniroma3.siw.model.Address;
import it.uniroma3.siw.model.Customer;

public class CustomerRepository extends SimpleRepositoryImpl<Customer> {

	private static final String SELECT_BY_NAME = "SELECT c FROM Customer c WHERE name = :name";
	private static final String CUSTOMER_ADDRESS_BY_ID = "SELECT c.address FROM Customer c WHERE c.id = :id";
	
	public CustomerRepository() {
		super(Customer.class);
	}

	public List<Customer> findByName(String name) {
		TypedQuery<Customer> query = this.getEntityManager()
				.createQuery(SELECT_BY_NAME, Customer.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	public Address findCustomerAddressById(Customer customer){
		TypedQuery<Address> query = this.getEntityManager().createQuery(CUSTOMER_ADDRESS_BY_ID, Address.class);
		query.setParameter("id", customer.getId());
		return query.getSingleResult();
	}	

}
