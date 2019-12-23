package com.cab.onlineshoppingbackends.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cab.onlineshoppingbackends.dao.IProductDAO;
import com.cab.onlineshoppingbackends.dto.Product;

@Repository("productDAOImpl")
@Transactional
public class ProductDAOImpl implements IProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// Single Objects

	@Override
	public Product get(int productId) {

		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	/// List

	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("From Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);

			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);

			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);

			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	// private boolean active from product Class
	@Override
	public List<Product> listActiveProducts() {

		String selectlistActiveProducts = "from Product where active=:active";
		return sessionFactory.getCurrentSession().createQuery(selectlistActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}
	// private int categoryId;

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectlistActiveProductsByCategory = "from Product where active=:active and categoryId=:categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectlistActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLetestActiveProducts(int count) {
		String getLetestActiveProducts = "from Product where active=:active order by id";
		return sessionFactory.getCurrentSession().createQuery(getLetestActiveProducts, Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
