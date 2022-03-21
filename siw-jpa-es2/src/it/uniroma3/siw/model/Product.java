package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	private Float price;
	
	@ManyToMany(mappedBy = "products")
	private List<Provider> providers;
	
}
