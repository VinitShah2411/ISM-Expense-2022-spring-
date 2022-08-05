package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CategoryBean;
import com.bean.CategorySubListBean;
import com.bean.UserBean;
import com.dao.CategoryDao;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;

	@GetMapping("/addcategory")
	public String addCategory(Model model, CategoryBean categoryBean) {
		model.addAttribute("category", categoryBean);
		return "AddCategory";
	}

	@PostMapping("/savecateogry")
	public String addCategory(@ModelAttribute("category") CategoryBean categoryBean, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute(categoryBean);
			return "AddCategory";
		} else {
			UserBean user = (UserBean) session.getAttribute("user");
			int userId = user.getUserId();
			categoryBean.setUserId(userId);
			categoryDao.addCategory(categoryBean);
			model.addAttribute(categoryBean);
			model.addAttribute("msg", "Category Added");
			return "Home";
		}
	}

	/*
	 * @GetMapping("/viewcategories") public String viewCategories(HttpSession
	 * session, Model model) {
	 * 
	 * UserBean userBean = (UserBean) session.getAttribute("user"); int userId =
	 * userBean.getUserId(); List<CategoryBean> categories =
	 * categoryDao.getAllCategoryByUser(userId); model.addAttribute("categories",
	 * categories); return "ListCategories"; }
	 */

	@GetMapping("/viewcategories")
	public String viewAllCategories(HttpSession session, Model model) {

		UserBean userBean = (UserBean) session.getAttribute("user");
		int userId = userBean.getUserId();
		List<CategorySubListBean> categories = categoryDao.getAllCategoriesByUser(userId);
		model.addAttribute("categories", categories);
		return "ListCategories";
	}

}
