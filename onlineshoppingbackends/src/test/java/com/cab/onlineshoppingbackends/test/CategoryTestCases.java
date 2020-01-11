package com.cab.onlineshoppingbackends.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cab.onlineshoppingbackends.dao.ICategoryDAO;
import com.cab.onlineshoppingbackends.dto.Category;

public class CategoryTestCases {

	/*private static AnnotationConfigApplicationContext context;
	private static ICategoryDAO icategoryDAO;
	private Category categorys;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.cab.onlineshoppingbackends");
		context.refresh();
		icategoryDAO = (ICategoryDAO) context.getBean("categoryDAO");

	}

	@Test
	public void testAddCategory() {

		categorys = new Category();
		categorys.setName("Tv  23");
		categorys.setDescription("This is for some description for Television!");
		categorys.setImageURL("cat_1.png");

		assertEquals("successfuly added category inside the table", true, icategoryDAO.add(categorys));
	}*/

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * categorys =icategoryDAO.get(3);
	 * 
	 * assertEquals("successfuly added category inside the table", "Tv",
	 * categorys.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * categorys =icategoryDAO.get(3); categorys.setName("Anjaiah");
	 * assertEquals("successfuly added category inside the table", true,
	 * icategoryDAO.update(categorys)); }
	 */

	/*
	 * @Test public void testdeleteCategory() {
	 * 
	 * categorys =icategoryDAO.get(3); categorys.setName("Anjaiah");
	 * assertEquals("successfuly added category inside the table", true,
	 * icategoryDAO.delete(categorys)); }
	 */

	/*
	 * @Test public void testgetAllCategory() {
	 * 
	 * assertEquals("successfuly added category inside the table", 2,
	 * icategoryDAO.list().size()); }
	 */

	/*
	 * @Test public void testCurdCategory() {
	 * 
	 * categorys = new Category(); categorys.setName("Tv");
	 * categorys.setDescription("This is for some description for Television!");
	 * categorys.setImageURL("cat_1.png");
	 * 
	 * assertEquals("successfuly added category inside the table", true,
	 * icategoryDAO.add(categorys));
	 * 
	 * categorys = new Category(); categorys.setName("Laptop");
	 * categorys.setDescription("This is for some description for Television!");
	 * categorys.setImageURL("cat_2.png");
	 * 
	 * categorys = new Category(); categorys.setName("Mobile");
	 * categorys.setDescription("This is for some description for Television!");
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
	 * icategoryDAO.list().size()); }
	 */

}
