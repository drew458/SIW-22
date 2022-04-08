package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.Order;
import it.uniroma3.siw.model.OrderLine;
import it.uniroma3.siw.model.Product;

public class OrderRepository {

	private EntityManager em;

	public Order save(Order order) {
		if(order.getId()!=null) {
			em.merge(order);
		}
		else {
			em.persist(order);
		}
		
		return order;
	}
	
	public Order findById(Long id) {
		return em.find(Order.class, id);
	}
	
	public List<Order> findAll(){
		return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
	}
	
	public void delete(Order order) {
		em.remove(order);
	}
	
	public void deleteAll() {
		this.em.createQuery("DELETE FROM Order").executeUpdate();
	}
	
	public long count() {
		return (Long)this.em.createQuery("SELECT Count(id) FROM Order").getSingleResult();
	}
	
	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}
	
	public List<OrderLine> findAllOrderLines(Order order) {
		return em.find(Order.class, order.getId()).getOrderlines();
	}
	
	public List<Product> findAllProducts(OrderLine orderLine) {
		return em.find(OrderLine.class, orderLine.getId()).getProducts();
	}
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
