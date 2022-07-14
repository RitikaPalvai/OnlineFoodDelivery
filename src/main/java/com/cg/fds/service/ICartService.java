package com.cg.fds.service;

import com.cg.fds.entities.Customer;
import com.cg.fds.entities.FoodCart;
import com.cg.fds.entities.Item;
import com.cg.fds.exception.RecordNotFound;

public interface ICartService {

	public FoodCart addItemToCart(FoodCart cart,Item item) throws RecordNotFound;
	public FoodCart increaseQuantity(FoodCart cart,Item item,int quantity) throws RecordNotFound;
	public FoodCart reduceQuantity(FoodCart cart,Item item,int quantity) throws RecordNotFound;
	public FoodCart removeItem(FoodCart cart,Item item) throws RecordNotFound;
	public FoodCart clearCart(FoodCart cart) throws RecordNotFound;
	
}
