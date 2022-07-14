package com.cg.fds.controller;

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
import com.cg.fds.service.ICustomerService;

@RestController
@RequestMapping("/ofs-customer")
public class ICustomerController {
	
	@Autowired
	ICustomerService iCustomerService;

	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) throws RecordNotFound{
		return iCustomerService.addCustomer(customer);
	}
	
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) throws RecordNotFound{
		return iCustomerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/removeCustomer")
	public Customer removeCustomer(@RequestBody Customer customer) throws RecordNotFound{
		return iCustomerService.removeCustomer(customer);
	}

	@GetMapping("/viewCustomer/{id}")
	public Customer viewCustomer(@PathVariable int id ) throws RecordNotFound{
		return iCustomerService.viewCustomer(id);
	}

}
