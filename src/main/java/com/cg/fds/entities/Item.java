package com.cg.fds.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="food_item") 
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cat_id", referencedColumnName = "catId")
	private Category category;
	
	private int quantity;
	private double cost;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "restaurant_food_items",
			joinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "itemId")},
			inverseJoinColumns = {@JoinColumn(name = "restaurant_id", referencedColumnName = "restaurantId")}
	)
	private List<Restaurant> restaurants;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "cart_id", referencedColumnName = "cartId")
	private FoodCart foodCart;

	public Item() {
		super();
	}

	public Item(int itemId, String itemName, Category category, int quantity, double cost,
			List<Restaurant> restaurants, FoodCart foodCart) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
		this.restaurants = restaurants;
		this.foodCart = foodCart;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public FoodCart getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
	}
	
	
}
