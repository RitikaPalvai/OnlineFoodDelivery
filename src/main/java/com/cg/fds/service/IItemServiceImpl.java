package com.cg.fds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.Category;
import com.cg.fds.entities.Customer;
import com.cg.fds.entities.Item;
import com.cg.fds.entities.Restaurant;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.repository.IItemRepository;
import com.cg.fds.repository.IRestaurantRepository;

@Service("IItemService")
public class IItemServiceImpl implements IItemService{
	
	@Autowired
	IItemRepository iItemRepository;
	
	@Autowired
	IRestaurantRepository iRestaurantRepository;

	
	public Item addItem(Item item) throws RecordNotFound {
		iItemRepository.saveAndFlush(item);
		return item;
	}

	
	public Item viewItem(int id) throws RecordNotFound {
		Item  bean = null;
		try {
			bean = iItemRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Item details not found!");
		}
		return bean;
	}

	
	public Item updateItem(Item item) throws RecordNotFound {
		Item  bean = null;
		try {
			bean = iItemRepository.findById(item.getItemId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Item details not found!");
		}
		iItemRepository.saveAndFlush(item);
		return bean;
	}

	
	public Item removeItem(int id) throws RecordNotFound {
		Item  bean = null;
		try {
			bean = iItemRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Item details not found!");
		}
		iItemRepository.deleteById(id);
		return bean;
	}

	
	public List<Item> viewAllItems(Restaurant res) throws RecordNotFound {
		Restaurant bean = null;
		try {
			bean = iRestaurantRepository.findById(res.getRestaurantId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Item details not found!");
		}
		return bean.getItemList();
	}

	
	public List<Item> viewAllItems() throws RecordNotFound {
		return iItemRepository.findAll();
	}

	
	public List<Item> viewAllItemsByName(String name) throws RecordNotFound {
		List<Item> items = new ArrayList<Item>();
		try {
			for(Item i : iItemRepository.findAll()) {
				if(i.getItemName().equals(name)) {
					items.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFound("Item details not found!");
		}
		return items;
	}

}
