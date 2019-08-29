package com.niit.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="Cart")
public class Cart implements Serializable{
	  @Id
	  
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
	  private String p_name;
	  private Float price;
	  private int quantity;
	  private String status;
	  private String u_id;
	  private int p_id;
	  /*@OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER, mappedBy = "cart")
		private Set<Product> products = new HashSet<Product>(0);
	  
	  

	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float float1) {
		this.price = float1;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	  

}
