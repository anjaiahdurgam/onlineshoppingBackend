package com.cab.onlineshoppingbackends.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cab.onlineshoppingbackends.dao.ICategoryDAO;
import com.cab.onlineshoppingbackends.dao.IProductDAO;
import com.cab.onlineshoppingbackends.dto.Category;
import com.cab.onlineshoppingbackends.dto.Product;


public class ProductsTestCases {

	private static AnnotationConfigApplicationContext context;
	private static IProductDAO iProductDAO;
	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.cab.onlineshoppingbackends");
		context.refresh();
		iProductDAO = (IProductDAO) context.getBean("productDAOImpl");

	}

	@Test
	public void testCurdCategory() {

		product = new Product();
		product.setName("Vinay 1");
		product.setCode("PRDPQR123WGTX");
		product.setBrand("Lenovo");
		product.setDescription("This is for some description for Laptop!");
		product.setUniteprice(28000.00);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(2);
		product.setQuantity(3);
		assertEquals("somthing wrongs added category inside the table", true, iProductDAO.add(product));

		/*
		 * categorys = new Category(); categorys.setName("Laptop"); categorys.
		 * setDescription("This is for some description for Television!");
		 * categorys.setImageURL("cat_2.png");
		 * 
		 * categorys = new Category(); categorys.setName("Mobile"); categorys.
		 * setDescription("This is for some description for Television!");
		 * categorys.setImageURL("cat_3.png");
		 * 
		 * assertEquals("successfuly added category inside the table", true,
		 * icategoryDAO.add(categorys)); // Update category categorys =
		 * icategoryDAO.get(1); categorys.setName("Anjaiah");
		 * assertEquals("successfuly added category inside the table", true,
		 * icategoryDAO.update(categorys));
		 * 
		 * // delete
		 * 
		 * categorys = icategoryDAO.get(3); categorys.setName("Anjaiah");
		 * assertEquals("successfuly added category inside the table", true,
		 * icategoryDAO.delete(categorys));
		 * 
		 * // fetch All
		 * 
		 * // assertEquals("successfuly added category inside the table", 1, //
		 * icategoryDAO.list().size());
		 */ }

}
