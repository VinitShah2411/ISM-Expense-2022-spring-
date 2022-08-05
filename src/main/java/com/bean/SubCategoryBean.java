package com.bean;

public class SubCategoryBean {

	private Integer category_id;
	private Integer subcategoryid;
	private String subcategory_name;
	private Integer userId;

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(Integer subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getSubcategory_name() {
		return subcategory_name;
	}

	public void setSubcategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}

}
