package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CategoryBean;
import com.bean.SubCategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;
import com.dao.SubCategoryDao;

@Controller
public class SubCategoryController {

	@Autowired
	SubCategoryDao subcategoryDao;
	
	@Autowired
	CategoryDao categoryDao;

	@GetMapping("/addsubcategory")
	public String subCategory(SubCategoryBean subcategoryBean,Model model,HttpSession session) {
//		subcategoryBean.setCategory_id(category_id);
		UserBean userBean=(UserBean)session.getAttribute("user");
		int userId=userBean.getUserId();
		model.addAttribute("subcategory", subcategoryBean);
		List<CategoryBean> categoryBean = categoryDao.getAllCategoryByUser(userId);
//		List<CategoryBean> categoryBean = categoryDao.getAllCategoryByUser(userId);
		model.addAttribute("category", categoryBean);
		return "AddSubCategory";
	}

	@PostMapping("/savesubcateogry")
	public String addsubCategory(@ModelAttribute("subcategory") SubCategoryBean subcategoryBean,
		 Model model, HttpSession session) {
//		subcategoryBean.setCategory_id(category_id);
		subcategoryDao.addSubCategory(subcategoryBean);
		model.addAttribute(subcategoryBean);
		model.addAttribute("msg", "Category Added");
		return "Home";
	}
}
