package com.cg.fds.repository;

import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.Customer;
import com.cg.fds.entities.Item;
import com.cg.fds.entities.OrderDetails;
import com.cg.fds.entities.Restaurant;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails,Integer>{

}
