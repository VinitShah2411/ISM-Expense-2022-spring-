package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;
import com.bean.CategorySubListBean;
import com.bean.SubCategoryBean;

@Repository
public class CategoryDao {

	@Autowired
	JdbcTemplate pstmt;

	public void addCategory(CategoryBean categoryBean) {
		pstmt.update("insert into categories (category_name,userid) values(?,?)", categoryBean.getCategory_name(),
				categoryBean.getUserId());
	}

	public List<CategoryBean> getAllCategoryByUser(int userId) {
		return pstmt.query("select * from categories where userid=?",
				new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class), userId);
	}

	public List<CategorySubListBean> getAllCategoriesByUser(int userId) {
		return pstmt.query(
				"select categories.category_name,subcategories.subcategory_name from categories inner join subcategories on subcategories.category_id=categories.category_id where userid=?",
				new BeanPropertyRowMapper<CategorySubListBean>(CategorySubListBean.class), userId);
	}

	public List<SubCategoryBean> listsubcategory(int category_id) {
		return pstmt.query("select * from subcategories where category_id=?",
				new BeanPropertyRowMapper<SubCategoryBean>(SubCategoryBean.class), new Object[] { category_id });
	}

}
