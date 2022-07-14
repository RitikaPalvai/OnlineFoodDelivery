package com.cg.fds.controller;

import java.util.List;

import com.cg.fds.entities.Restaurant;
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
import com.cg.fds.service.IRestaurantService;

@RestController
@RequestMapping("/ofs-restaurant")
public class IRestaurantController {
	
	@Autowired
	IRestaurantService iRestaurantService;
	
	@PostMapping("/addRestaurant")
	public Restaurant addRestaurant(@RequestBody Restaurant res) throws RecordNotFound{
		return iRestaurantService.addRestaurant(res);
	}
	
	@DeleteMapping("/removeRestaurant")
	public Restaurant removeRestaurant(@RequestBody Restaurant res) throws RecordNotFound{
		return iRestaurantService.removeRestaurant(res);
	}
	
	@PutMapping("/updateRestaurant")
	public Restaurant updateRestaurant(@RequestBody Restaurant res) throws RecordNotFound{
		return iRestaurantService.updateRestaurant(res);
	}
	
	@GetMapping("/viewRestaurant/{name}")
	public Restaurant viewRestaurant(@PathVariable String name) throws RecordNotFound{
		return iRestaurantService.viewRestaurant(name);
	}
	
	@GetMapping("/viewAllRestaurants")
	public List<Restaurant> viewAllRestaurants() throws RecordNotFound{
		return iRestaurantService.viewAllRestaurants();
	}
	
	@GetMapping("/viewNearByRestaurant/{location}")
	public List<Restaurant> viewNearByRestaurant(@PathVariable String location) throws RecordNotFound{
		return iRestaurantService.viewNearByRestaurant(location);
	}

}
