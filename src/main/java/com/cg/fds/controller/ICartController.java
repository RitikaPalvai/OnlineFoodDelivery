package com.cg.fds.controller;

import com.cg.fds.entities.FoodCart;
import com.cg.fds.entities.Item;
import com.cg.fds.exception.RecordNotFound;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fds.entities.Bill;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.service.IBillService;
import com.cg.fds.service.ICartService;

@RestController
@RequestMapping("/ofs-cart")
public class ICartController {
	
	@Autowired
	ICartService iCartService;

	@PostMapping("/addItemToCart")
	public FoodCart addItemToCart(@RequestBody FoodCart cart,@RequestBody Item item) throws RecordNotFound{
		return iCartService.addItemToCart(cart, item);
	}
	
	@PutMapping("/increaseQuantity/{quantity}")
	public FoodCart increaseQuantity(@RequestBody FoodCart cart,@RequestBody Item item, @PathVariable int quantity) throws RecordNotFound{
		return iCartService.increaseQuantity(cart, item, quantity);
	}

	@PutMapping("/reduceQuantity/{quantity}")
	public FoodCart reduceQuantity(@RequestBody FoodCart cart,@RequestBody Item item,@PathVariable int quantity) throws RecordNotFound{
		return iCartService.reduceQuantity(cart, item, quantity);
	}
	
	@DeleteMapping("/removeItem")
	public FoodCart removeItem(@RequestBody FoodCart cart,@RequestBody Item item) throws RecordNotFound{
		return iCartService.removeItem(cart, item);
	}
	
	@DeleteMapping("/clearCart")
	public FoodCart clearCart(@RequestBody FoodCart cart) throws RecordNotFound{
		return iCartService.clearCart(cart);
	}

}
