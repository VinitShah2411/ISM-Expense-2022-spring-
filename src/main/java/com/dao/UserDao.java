package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate pstmt;

	public void addUser(UserBean user) {
		pstmt.update("insert into expense_tracker (firstname,lastname,email,password,usertype) values(?,?,?,?,?) ",
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getUserType());
	}

	public UserBean authenticate(LoginBean loginBean) {
		UserBean user = null;
		try {
			user = pstmt.queryForObject("select * from expense_tracker where email=? and password=?",
					new BeanPropertyRowMapper<UserBean>(UserBean.class),
					new Object[] { loginBean.getEmail(), loginBean.getPassword() });
		} catch (Exception e) {
			System.out.println("Invalid Email or Password");
		}
		return user;
	}
}
