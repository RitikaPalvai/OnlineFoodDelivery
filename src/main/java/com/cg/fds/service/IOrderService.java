package com.cg.fds.service;

import java.util.List;

import com.cg.fds.entities.Customer;
import com.cg.fds.entities.OrderDetails;
import com.cg.fds.entities.Restaurant;
import com.cg.fds.exception.RecordNotFound;

public interface IOrderService {

	public OrderDetails addOrder(OrderDetails order) throws RecordNotFound;
	public OrderDetails updateOrder(OrderDetails order) throws RecordNotFound;
	public OrderDetails removeOrder(OrderDetails order) throws RecordNotFound;
	public OrderDetails viewOrder(OrderDetails order) throws RecordNotFound;
	public List<OrderDetails> viewAllOrders() throws RecordNotFound;
	
}
