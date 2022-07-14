package com.cg.fds.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.Bill;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.repository.IBillRepository;

@Service("IBillService")
public class IBillServiceImpl implements IBillService{
	
	@Autowired
	IBillRepository iBillRepository;

	
	public Bill addBill(Bill bill) throws RecordNotFound {
		iBillRepository.saveAndFlush(bill);
		return bill;
	}

	
	public Bill updateBill(Bill bill) throws RecordNotFound {
		Bill  bean = null;
		try {
			bean = iBillRepository.findById(bill.getBillId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Bill details not found!");
		}
		iBillRepository.saveAndFlush(bill);
		return bean;
	}

	
	public Bill removeBill(Bill bill) throws RecordNotFound {
		Bill  bean = null;
		try {
			bean = iBillRepository.findById(bill.getBillId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Bill details not found!");
		}
		iBillRepository.deleteById(bill.getBillId());
		return bean;
	}

	
	public Bill viewBill(Bill bill) throws RecordNotFound {
		Bill  bean = null;
		try {
			bean = iBillRepository.findById(bill.getBillId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Bill details not found!");
		}
		return bean;
	}

	
	public List<Bill> viewBills() throws RecordNotFound {
		return iBillRepository.findAll();
	}

}
