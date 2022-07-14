package com.cg.fds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.fds.entities.Item;
import com.cg.fds.entities.Restaurant;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.service.IItemService;

import com.cg.fds.entities.Customer;
import com.cg.fds.exception.RecordNotFound;


import java.util.List;

import com.cg.fds.entities.Category;
import com.cg.fds.exception.RecordNotFound;
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
import com.cg.fds.service.ICategoryService;

@RestController
@RequestMapping("/ofs-item")
public class IItemController {
	
	@Autowired
	IItemService iItemService;
	
	@PostMapping("/addCustomer")
	public Item addItem(@RequestBody Item item) throws RecordNotFound{
		return iItemService.addItem(item);
	}
	
	@GetMapping("/viewItem/{id}")
	public Item viewItem(@PathVariable int id) throws RecordNotFound{
		return iItemService.viewItem(id);
	}
	
	@PutMapping("/updateItem")
	public Item updateItem(@RequestBody Item item) throws RecordNotFound{
		return iItemService.updateItem(item);
	}
	
	@DeleteMapping("/removeItem/{id}")
	public Item removeItem(@PathVariable int id) throws RecordNotFound{
		return iItemService.removeItem(id);
	}
	
	@GetMapping("/viewAllItems")
	public List<Item> viewAllItems(@RequestBody Restaurant res) throws RecordNotFound{
		return iItemService.viewAllItems(res);
	}
	
	@GetMapping("/viewAllItemsByName/{name}")
	public List<Item> viewAllItemsByName(@PathVariable String name) throws RecordNotFound{
		return iItemService.viewAllItemsByName(name);
	}

}
