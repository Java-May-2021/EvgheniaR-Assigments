package com.evghenia.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evghenia.productsandcategories.models.Category;
import com.evghenia.productsandcategories.models.Product;
import com.evghenia.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	public List<Product> getAll(){
		return this.pRepo.findAll();
	}
	public Product createProduct(Product product) {
		return pRepo.save(product);
	}
	public Product getById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public Product updateProduct(Product product) {
		return pRepo.save(product);
	}
	public List<Product> getsUniqueCats(Category category){
		return this.pRepo.findByCategoriesNotContains(category);
	}
}