package com.cab.onlineshoppingbackends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cab.onlineshoppingbackends.dao.IProductDAO;
import com.cab.onlineshoppingbackends.dto.Product;



@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private IProductDAO iProductDAO;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {

		return iProductDAO.listActiveProducts();

	}

	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin() {

		return iProductDAO.list();

	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {

		return iProductDAO.listActiveProductsByCategory(id);

	}

}
