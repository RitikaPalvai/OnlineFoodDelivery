package com.cg.fds.service;

import java.util.List;

import com.cg.fds.entities.Restaurant;
import com.cg.fds.exception.RecordNotFound;

public interface IRestaurantService {

	public Restaurant addRestaurant(Restaurant res) throws RecordNotFound;
	public Restaurant removeRestaurant(Restaurant res) throws RecordNotFound;
	public Restaurant updateRestaurant(Restaurant res) throws RecordNotFound;
	public Restaurant viewRestaurant(String name) throws RecordNotFound;
	public List<Restaurant> viewAllRestaurants() throws RecordNotFound;
	public List<Restaurant> viewNearByRestaurant(String location) throws RecordNotFound;
}
