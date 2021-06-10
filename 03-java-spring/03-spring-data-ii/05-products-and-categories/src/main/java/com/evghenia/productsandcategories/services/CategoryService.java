package com.evghenia.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evghenia.productsandcategories.models.Category;
import com.evghenia.productsandcategories.models.Product;
import com.evghenia.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository catRepo;
	
	public List<Category> getAll(){
		return this.catRepo.findAll();
	}
	public Category createCategory(Category category) {
		return catRepo.save(category);
	}
	public Category getById(Long id) {
		return this.catRepo.findById(id).orElse(null);
	}
	public Category updateCategory(Category category) {
		return catRepo.save(category);
	}
	public List<Category> getUniqueProducts(Product product){
		return this.catRepo.findByProductsNotContains(product);
	}
}
