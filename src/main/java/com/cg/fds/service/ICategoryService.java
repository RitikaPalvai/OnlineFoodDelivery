package com.cg.fds.service;

import java.util.List;

import com.cg.fds.entities.Category;
import com.cg.fds.exception.RecordNotFound;

public interface ICategoryService {

	public Category addCategory(Category cat) throws RecordNotFound;
	public Category updateCategory(Category cat) throws RecordNotFound;
	public Category removeCategory(Category cat) throws RecordNotFound;
	public Category viewCategory(Category cat) throws RecordNotFound; 
	public List<Category> viewAllCategory() throws RecordNotFound;
}
