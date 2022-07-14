package com.cg.fds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.Bill;
import com.cg.fds.entities.FoodCart;
import com.cg.fds.entities.Item;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.repository.ICartRepository;

@Service("ICartService")
public class ICartServiceImpl implements ICartService {
	
	@Autowired
	ICartRepository iCartRepository;

	
	public FoodCart addItemToCart(FoodCart cart, Item item) throws RecordNotFound {
		iCartRepository.saveAndFlush(cart);
		cart.getItemList().add(item);	
		return cart;
	}


	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity) throws RecordNotFound {
		FoodCart  bean = null;
		try {
			bean = iCartRepository.findById(cart.getCartId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Cart details not found!");
		}
		for(Item i : bean.getItemList()) {
			i.setQuantity(i.getQuantity()+quantity);
		}
		return cart;
	}

	
	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity) throws RecordNotFound {
		FoodCart  bean = null;
		try {
			bean = iCartRepository.findById(cart.getCartId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Cart details not found!");
		}
		for(Item i : bean.getItemList()) {
			i.setQuantity(i.getQuantity()-quantity);
		}
		return cart;
	}

	
	public FoodCart removeItem(FoodCart cart, Item item) throws RecordNotFound {
		FoodCart  bean = null;
		try {
			bean = iCartRepository.findById(cart.getCartId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Cart details not found!");
		}
		for(Item i : bean.getItemList()) {
			if(i.getItemId()==item.getItemId()) {
				bean.getItemList().remove(item);
			}
		}
		return cart;
	}

	
	public FoodCart clearCart(FoodCart cart) throws RecordNotFound {
		FoodCart  bean = null;
		try {
			bean = iCartRepository.findById(cart.getCartId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Cart details not found!");
		}
		iCartRepository.deleteById(cart.getCartId());
		return cart;
	}

}
