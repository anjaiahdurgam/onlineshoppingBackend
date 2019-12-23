package com.cab.onlineshoppingbackends.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cab.onlineshoppingbackends.dao.ICategoryDAO;
import com.cab.onlineshoppingbackends.dao.IProductDAO;
import com.cab.onlineshoppingbackends.dto.Category;
import com.cab.onlineshoppingbackends.dto.Product;
import com.cab.onlineshoppingbackends.exception.ProductNotFoundException;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private ICategoryDAO categoryDAO;
	@Autowired
	private IProductDAO iProductDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView view = new ModelAndView("page");
		view.addObject("title", "Home");

		logger.debug("Inside page controller index methods");
		logger.info("Inside page controller index methods info");

		view.addObject("categories", categoryDAO.list());

		view.addObject("userClickHome", true);

		return view;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView view = new ModelAndView("page");
		view.addObject("title", "About Us");
		view.addObject("userClickAbout", true);

		return view;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView view = new ModelAndView("page");
		view.addObject("title", "Contact Us");
		view.addObject("userClickContact", true);

		return view;
	}

	/* Method to load all the product and the category based on category */
	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {

		ModelAndView view = new ModelAndView("page");

		view.addObject("title", "All products");
		view.addObject("categories", categoryDAO.list());

		view.addObject("userClickAllProducts", true);

		return view;
	}

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView view = new ModelAndView("page");

		// category dao to fetch single category
		Category category = null;
		category = categoryDAO.get(id);
		// passing list of the category
		view.addObject("title", category.getName());
		view.addObject("categories", categoryDAO.list());
		// passing single of the category
		view.addObject("category", category);

		view.addObject("userClickCategoryProducts", true);

		return view;
	}

	/*
	 * Viewing a single product
	 */

	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {

		ModelAndView mv = new ModelAndView("page");

		Product product = iProductDAO.get(id);

		if (product == null)
			throw new ProductNotFoundException();

		// update the view count
		product.setView(product.getView() + 1);
		iProductDAO.update(product);
		// ---------------------------

		mv.addObject("title", product.getName());
		mv.addObject("product", product);

		mv.addObject("userClickShowProduct", true);

		return mv;

	}

	@RequestMapping(value = "/register")
	public ModelAndView register() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");

		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {

		ModelAndView mv = new ModelAndView("login");
		if (error != null) {
			mv.addObject("message", "Invalid Username and Password!");
		}
		if (logout != null) {
			mv.addObject("logout", "User has successfully logged out!");
		}
		mv.addObject("title", "Login");
		return mv;
	}

	// access denied page

	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Aha! Caught You.");
		mv.addObject("errorDescription", "You are not authorized to view this page!");
		return mv;
	}

	// Logout

	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		// first we are going to fetch the authentication
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login?logout";
	}
}
