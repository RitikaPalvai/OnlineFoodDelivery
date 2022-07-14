package com.cg.fds.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.Bill;

@Repository
public interface IBillRepository extends JpaRepository<Bill,Integer>{

	
}
