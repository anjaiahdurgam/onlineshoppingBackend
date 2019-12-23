package com.cab.onlineshoppingbackends.dao;

import java.util.List;

import com.cab.onlineshoppingbackends.dto.Product;

public interface IProductDAO {

	Product get(int productId);

	List<Product> list();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);

	// bussiness methodes

	List<Product> listActiveProducts();

	List<Product> listActiveProductsByCategory(int categoryId);

	List<Product> getLetestActiveProducts(int count);

}
