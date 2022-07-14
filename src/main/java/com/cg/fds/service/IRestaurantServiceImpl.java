package com.cg.fds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.OrderDetails;
import com.cg.fds.entities.Restaurant;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.repository.IRestaurantRepository;

@Service("IRestaurantService")
public class IRestaurantServiceImpl implements IRestaurantService{
	
	@Autowired
	IRestaurantRepository iRestaurantRepository;

	
	public Restaurant addRestaurant(Restaurant res) throws RecordNotFound {
		iRestaurantRepository.saveAndFlush(res);
		return res;
	}

	
	public Restaurant removeRestaurant(Restaurant res) throws RecordNotFound {
		Restaurant bean = null;
		try {
			bean = iRestaurantRepository.findById(res.getRestaurantId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Restaurant details not found!");
		}
		iRestaurantRepository.deleteById(res.getRestaurantId());
		return bean;
	}

	
	public Restaurant updateRestaurant(Restaurant res) throws RecordNotFound {
		Restaurant bean = null;
		try {
			bean = iRestaurantRepository.findById(res.getRestaurantId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Restaurant details not found!");
		}
		iRestaurantRepository.saveAndFlush(res);
		return bean;
	}

	
	public Restaurant viewRestaurant(String name) throws RecordNotFound {
		List<Restaurant> appointments = new ArrayList<Restaurant>();
		try {
			for(Restaurant i : iRestaurantRepository.findAll()) {
				if(i.getRestaurantName().equals(name)) {
					return i;
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFound("Restaurant details not found!");
		}
		return null;
	}

	
	public List<Restaurant> viewAllRestaurants() throws RecordNotFound {
		return iRestaurantRepository.findAll();
	}


	public List<Restaurant> viewNearByRestaurant(String location) throws RecordNotFound {
		List<Restaurant> appointments = new ArrayList<Restaurant>();
		try {
			for(Restaurant i : iRestaurantRepository.findAll()) {
				if(i.getAddress().getCity().equals(location)) {
					appointments.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFound("Restaurant details not found!");
		}
		return appointments;
	}


}
