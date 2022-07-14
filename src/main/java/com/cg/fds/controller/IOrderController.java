package com.cg.fds.controller;

import java.util.List;

import com.cg.fds.entities.OrderDetails;
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
import com.cg.fds.service.IOrderService;

@RestController
@RequestMapping("/ofs-order")
public class IOrderController {
	
	@Autowired
	IOrderService iOrderService;
	
	
	@PostMapping("/addOrder")
	public OrderDetails addOrder(@RequestBody OrderDetails order) throws RecordNotFound{
		return iOrderService.addOrder(order);
	}
	
	@PutMapping("/updateOrder")
	public OrderDetails updateOrder(@RequestBody OrderDetails order) throws RecordNotFound{
		return iOrderService.updateOrder(order);
	}
	
	@DeleteMapping("/removeOrder")
	public OrderDetails removeOrder(@RequestBody OrderDetails order) throws RecordNotFound{
		return iOrderService.removeOrder(order);
	}
	
	@GetMapping("/viewOrder")
	public OrderDetails viewOrder(@RequestBody OrderDetails order) throws RecordNotFound{
		return iOrderService.viewOrder(order);
	}
	
	@GetMapping("/viewAllOrders")
	public List<OrderDetails> viewAllOrders() throws RecordNotFound{
		return iOrderService.viewAllOrders();
	}

}
