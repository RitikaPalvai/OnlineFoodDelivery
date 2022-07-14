package com.cg.fds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fds.entities.Bill;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.service.IBillService;

@RestController
@RequestMapping("/ofs-bill")
public class IBillController {
	
	@Autowired
	IBillService iBillService;
	
	@PostMapping("/addBill")
	public Bill addBill(@RequestBody Bill bill) throws RecordNotFound{
		return iBillService.addBill(bill);
	}
	
	@PutMapping("/updateBill")
	public Bill updateBill(@RequestBody Bill bill) throws RecordNotFound{
		return iBillService.updateBill(bill);
	}
	
	@DeleteMapping("/removeBill")
	public Bill removeBill(@RequestBody Bill bill) throws RecordNotFound{
		return iBillService.removeBill(bill);
	}
	
	@GetMapping("/viewBill")
	public Bill viewBill(@RequestBody Bill bill) throws RecordNotFound{
		return iBillService.viewBill(bill);
	}
	
	@GetMapping("/viewBills")
	public List<Bill> viewBills() throws RecordNotFound{
		return iBillService.viewBills();
	}

}
