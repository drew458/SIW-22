package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import it.uniroma3.siw.model.Order;
import it.uniroma3.siw.model.OrderLine;
import it.uniroma3.siw.model.Product;

public class OrderRepository extends SimpleRepositoryImpl<Order> {

	private static final String SELECT_ORDERLINES_BY_ID = "SELECT o.orderlines FROM Order o WHERE o.id = :id";
	private static final String SELECT_PRODCUTS_BY_ID = "SELECT ol.products FROM OrderLine ol WHERE ol.id = :id";
	
	public OrderRepository() {
		super(Order.class);
	}

	public List<OrderLine> findAllOrderLines(Order order){
		TypedQuery<OrderLine> query = this.getEntityManager().createQuery(SELECT_ORDERLINES_BY_ID, OrderLine.class);
		query.setParameter("id", order.getId());
		return query.getResultList();
	}
	
	public List<Product> findAllProducts(OrderLine orderLine){
		TypedQuery<Product> query = this.getEntityManager().createQuery(SELECT_PRODCUTS_BY_ID, Product.class);
		query.setParameter("id", orderLine.getId());
		return query.getResultList();
	}
	
}
