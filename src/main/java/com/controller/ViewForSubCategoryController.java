package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.SubCategoryBean;
import com.dao.CategoryDao;

@RestController
public class ViewForSubCategoryController {

	@Autowired
	CategoryDao categoryDao;
	
	@GetMapping("/subcategory")
	public List<SubCategoryBean> subcategory(@RequestParam("category_id") int category_id) {
		return categoryDao.listsubcategory(category_id);
		 
	}
}
