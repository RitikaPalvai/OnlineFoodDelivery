package com.cg.fds.service;

import java.util.List;

import com.cg.fds.entities.Category;
import com.cg.fds.entities.Item;
import com.cg.fds.entities.Restaurant;
import com.cg.fds.exception.RecordNotFound;

public interface IItemService {

	public Item addItem(Item item) throws RecordNotFound;
	public Item viewItem(int id) throws RecordNotFound;
	public Item updateItem(Item item) throws RecordNotFound;
	public Item removeItem(int id) throws RecordNotFound;
	public List<Item> viewAllItems(Restaurant res) throws RecordNotFound;
	public List<Item> viewAllItems() throws RecordNotFound;
	public List<Item> viewAllItemsByName(String name) throws RecordNotFound;
	
}
