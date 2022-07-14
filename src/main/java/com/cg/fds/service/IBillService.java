package com.cg.fds.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.fds.entities.Bill;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.repository.IBillRepository;

public interface IBillService {


	public Bill addBill(Bill bill) throws RecordNotFound;
	public Bill updateBill(Bill bill) throws RecordNotFound;
	public Bill removeBill(Bill bill) throws RecordNotFound;
	public Bill viewBill(Bill bill) throws RecordNotFound;
	public List<Bill> viewBills() throws RecordNotFound;
	
}
