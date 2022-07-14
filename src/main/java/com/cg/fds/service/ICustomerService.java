package com.cg.fds.service;

import java.util.List;

import com.cg.fds.entities.Customer;
import com.cg.fds.exception.RecordNotFound;

public interface ICustomerService {

	public Customer addCustomer(Customer customer) throws RecordNotFound;
	public Customer updateCustomer(Customer customer) throws RecordNotFound;
	public Customer removeCustomer(Customer customer) throws RecordNotFound;
	public Customer viewCustomer(int id ) throws RecordNotFound;
}
