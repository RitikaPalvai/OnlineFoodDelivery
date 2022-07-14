package com.cg.fds.repository;

import com.cg.fds.entities.Customer;
import com.cg.fds.entities.FoodCart;
import com.cg.fds.entities.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.Bill;

@Repository
public interface ICartRepository extends JpaRepository<FoodCart,Integer>{

	
}
