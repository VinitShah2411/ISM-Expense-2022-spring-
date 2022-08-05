package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.SubCategoryBean;

@Repository
public class SubCategoryDao {

	@Autowired
	JdbcTemplate pstmt;

	public void addSubCategory(SubCategoryBean subcategoryBean) {
		pstmt.update("insert into subcategories (subcategory_name,category_id) values(?,?)",
				subcategoryBean.getSubcategory_name(), subcategoryBean.getCategory_id());
	}

	public List<SubCategoryBean> getAllSubCategoryByUser(int category_id) {
		return pstmt.query("select * from subcategories where category_id=?",
				new BeanPropertyRowMapper<SubCategoryBean>(SubCategoryBean.class), category_id);
	}
}
