package com.cab.onlineshoppingbackends.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cab.onlineshoppingbackends.dao.ICategoryDAO;
import com.cab.onlineshoppingbackends.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements ICategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * private static List<Category> categories = new ArrayList<>();
	 * 
	 * static { Category category = new Category(); category.setId(1);
	 * category.setName("Television");
	 * category.setDescription("This is for some description for Television!");
	 * category.setImageURL("cat_1.png");
	 * 
	 * categories.add(category); category.setId(2); category.setName("Mobile");
	 * category.setDescription("This is for some description for Mobile!");
	 * category.setImageURL("cat_2.png");
	 * 
	 * categories.add(category);
	 * 
	 * category.setId(3); category.setName("Laptop");
	 * category.setDescription("This is for some description for Laptop!");
	 * category.setImageURL("cat_3.png");
	 * 
	 * categories.add(category);
	 * 
	 * }
	 */

	@Override
	public List<Category> list() {

		String selectActiveCategory = "from Category where active=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();

	}

	// getting single category based on the id
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {

			// Add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

}
