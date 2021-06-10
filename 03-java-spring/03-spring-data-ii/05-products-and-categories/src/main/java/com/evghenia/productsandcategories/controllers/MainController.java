package com.evghenia.productsandcategories.controllers;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evghenia.productsandcategories.models.Category;
import com.evghenia.productsandcategories.models.Product;
import com.evghenia.productsandcategories.services.CategoryService;
import com.evghenia.productsandcategories.services.ProductService;

@Controller
public class MainController {
	@Autowired
	private ProductService pService;
	@Autowired
	private CategoryService catService;
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product")Product product) {
		return "product.jsp";
	}
	@PostMapping(value="/products/new")
	public String createProduct(@Valid@ModelAttribute("product")Product product,BindingResult result) {
		if(result.hasErrors()) {
			return "product.jsp";
		}else {
			this.pService.createProduct(product);
			return "redirect:/products/" +  product.getId();
		}
	}
	@GetMapping("/products/{id}")
	public String showProduct(@ModelAttribute("category")Category category, @PathVariable("id")Long id,Model model) {
		Product newProduct = pService.getById(id);
		model.addAttribute("product",newProduct);
		List<Category> allCategories = this.catService.getUniqueProducts(newProduct);
		model.addAttribute("categories",allCategories);
		return "productShow.jsp";
	}
	@PostMapping(value="/products/{id}")
	public String createCategoryToProduct(@PathVariable("id")Long productId,@RequestParam("category")Long categoryId) {
		Product product = pService.getById(productId);
		Category category = catService.getById(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		product.setCategories(categories);
		pService.createProduct(product);
		return "redirect:/products/" + product.getId();
		
	}
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category")Category category) {
		return "category.jsp";
	}
	@PostMapping(value="/categories/new")
	public String createCategory(@Valid@ModelAttribute("category")Category category,BindingResult result) {
		if(result.hasErrors()) {
			return "category.jsp";
		}else {
			this.catService.createCategory(category);
			return "redirect:/categories/" + category.getId();
		}
	}
	@GetMapping("/categories/{id}")
	public String showCategory(@ModelAttribute("category")Category category,@PathVariable("id")Long id,Model model) {
		Category newCategory = this.catService.getById(id);
		model.addAttribute("category",newCategory);
		List<Product> allProducts = this.pService.getsUniqueCats(newCategory);
		model.addAttribute("products",allProducts);
		return "categoryShow.jsp";
	}
	@PostMapping(value="/categories/{id}")
	public String createProductToCategory(@PathVariable("id")Long categoryId,@RequestParam("product")Long productId) {
		Category category = this.catService.getById(categoryId);
		Product product = this.pService.getById(productId);
		List<Product> products = category.getProducts();
		products.add(product);
		category.setProducts(products);
		catService.createCategory(category);
		return "redirect:/categories/" + category.getId();
	}
}
