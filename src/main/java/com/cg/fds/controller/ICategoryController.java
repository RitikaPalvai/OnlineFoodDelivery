package com.cg.fds.controller;

import java.util.List;

import com.cg.fds.entities.Category;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.entities.FoodCart;
import com.cg.fds.entities.Item;
import com.cg.fds.exception.RecordNotFound;

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
import com.cg.fds.service.ICartService;
import com.cg.fds.service.ICategoryService;

@RestController
@RequestMapping("/ofs-category")
public class ICategoryController {
	
	@Autowired
	ICategoryService iCategoryService;
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody Category cat) throws RecordNotFound{
		return iCategoryService.addCategory(cat);
	}
	
	@PutMapping("/updateCategory")
	public Category updateCategory(@RequestBody Category cat) throws RecordNotFound{
		return iCategoryService.updateCategory(cat);
	}
	
	@DeleteMapping("/removeCategory")
	public Category removeCategory(@RequestBody Category cat) throws RecordNotFound{
		return iCategoryService.removeCategory(cat);
	}
	
	@GetMapping("/viewCategory")
	public Category viewCategory(@RequestBody Category cat) throws RecordNotFound{
		return iCategoryService.viewCategory(cat);
	}
	
	@GetMapping("/viewAllCategory")
	public List<Category> viewAllCategory() throws RecordNotFound{
		return iCategoryService.viewAllCategory();
	}

}
