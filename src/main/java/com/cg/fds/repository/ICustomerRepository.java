package com.cg.fds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.Customer;
import com.cg.fds.entities.FoodCart;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer,Integer>{

}
