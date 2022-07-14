package com.cg.fds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.Item;
import com.cg.fds.entities.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login,Integer>{
	
}
