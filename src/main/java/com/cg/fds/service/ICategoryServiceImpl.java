package com.cg.fds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.Category;
import com.cg.fds.entities.FoodCart;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.repository.ICategoryRepository;

@Service("ICategoryService")
public class ICategoryServiceImpl implements ICategoryService{
	
	@Autowired
	ICategoryRepository iCategoryService;

	
	public Category addCategory(Category cat) throws RecordNotFound {
		iCategoryService.saveAndFlush(cat);
		return cat;
	}

	
	public Category updateCategory(Category cat) throws RecordNotFound {
		Category  bean = null;
		try {
			bean = iCategoryService.findById(cat.getCatId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Category details not found!");
		}
		iCategoryService.saveAndFlush(cat);
		return cat;
	}

	
	public Category removeCategory(Category cat) throws RecordNotFound {
		Category  bean = null;
		try {
			bean = iCategoryService.findById(cat.getCatId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Category details not found!");
		}
		iCategoryService.deleteById(cat.getCatId());
		return cat;
	}

	
	public Category viewCategory(Category cat) throws RecordNotFound {
		Category  bean = null;
		try {
			bean = iCategoryService.findById(cat.getCatId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Category details not found!");
		}
		return cat;
	}

	
	public List<Category> viewAllCategory() throws RecordNotFound {
		return iCategoryService.findAll();
	}

}
