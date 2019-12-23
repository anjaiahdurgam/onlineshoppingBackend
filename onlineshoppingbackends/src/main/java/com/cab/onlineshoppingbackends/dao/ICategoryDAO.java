package com.cab.onlineshoppingbackends.dao;

import java.util.List;

import com.cab.onlineshoppingbackends.dto.Category;

public interface ICategoryDAO {

	Category get(int id);

	List<Category> list();

	boolean add(Category category);

	boolean update(Category category);

	boolean delete(Category category);

}
