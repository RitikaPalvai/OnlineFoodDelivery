package com.cg.fds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.Customer;
import com.cg.fds.entities.Login;
import com.cg.fds.entities.OrderDetails;
import com.cg.fds.entities.Restaurant;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.repository.IOrderRepository;

@Service("IOrderService")
public class IOrderServiceImpl implements IOrderService{
	
	@Autowired
	IOrderRepository iOrderRepository;


	public OrderDetails addOrder(OrderDetails order) throws RecordNotFound {
		iOrderRepository.saveAndFlush(order);
		return order;
	}

	
	public OrderDetails updateOrder(OrderDetails order) throws RecordNotFound {
		OrderDetails bean = null;
		try {
			bean = iOrderRepository.findById(order.getOrderId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Order details not found!");
		}
		iOrderRepository.saveAndFlush(order);
		return bean;
	}

	
	public OrderDetails removeOrder(OrderDetails order) throws RecordNotFound {
		OrderDetails bean = null;
		try {
			bean = iOrderRepository.findById(order.getOrderId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Order details not found!");
		}
		iOrderRepository.deleteById(order.getOrderId());
		return bean;
	}

	
	public OrderDetails viewOrder(OrderDetails order) throws RecordNotFound {
		OrderDetails bean = null;
		try {
			bean = iOrderRepository.findById(order.getOrderId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Order details not found!");
		}
		return bean;
	}

	
	public List<OrderDetails> viewAllOrders() throws RecordNotFound {
		return iOrderRepository.findAll();
	}

}
