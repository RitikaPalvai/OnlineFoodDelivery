package com.cg.fds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.Category;
import com.cg.fds.entities.Customer;
import com.cg.fds.entities.Item;
import com.cg.fds.entities.Restaurant;

@Repository
public interface IItemRepository extends JpaRepository<Item,Integer>{


	
}
