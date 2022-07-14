package com.cg.fds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.Category;
import com.cg.fds.entities.Customer;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.repository.ICustomerRepository;

@Service("ICustomerService")
public class ICustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerRepository iCustomerRepository;

	
	public Customer addCustomer(Customer customer) throws RecordNotFound {
		iCustomerRepository.saveAndFlush(customer);
		return customer;
	}

	
	public Customer updateCustomer(Customer customer) throws RecordNotFound {
		Customer  bean = null;
		try {
			bean = iCustomerRepository.findById(customer.getCustomerId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Customer details not found!");
		}
		iCustomerRepository.saveAndFlush(customer);
		return customer;
	}

	
	public Customer removeCustomer(Customer customer) throws RecordNotFound {
		Customer  bean = null;
		try {
			bean = iCustomerRepository.findById(customer.getCustomerId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Customer details not found!");
		}
		iCustomerRepository.deleteById(customer.getCustomerId());
		return customer;
	}

	
	public Customer viewCustomer(int id) throws RecordNotFound {
		Customer  bean = null;
		try {
			bean = iCustomerRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Customer details not found!");
		}
		return bean;
	}


}
