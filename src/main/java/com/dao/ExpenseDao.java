package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ExpenseBean;

@Repository
public class ExpenseDao {

	@Autowired
	JdbcTemplate pstmt;

	public void addExpense(ExpenseBean expense) {
		pstmt.update(
				"insert into expense_details (userid,expense_name,expense_description,categoryid,subcategoryid,expense_amount,expense_date,expense_time,expense_paymentmode) values(?,?,?,?,?,?,?,?,?)",
				expense.getUserId(), expense.getExpense_name(), expense.getExpense_description(),
				expense.getCategoryId(), expense.getSubcategoryId(), expense.getExpense_amount(),
				expense.getExpense_date(), expense.getExpense_date(), expense.getExpense_paymentmode());
	}

	public List<ExpenseBean> getAllExpenseByUser(int userId) {
		return pstmt.query("select * from expense_details where userid=?",
				new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class), userId);
	}

	public void deleteExpense(int expenseId) {
		pstmt.update("delete from expense_details where expense_id=?", expenseId);
	}

	public ExpenseBean getExpenseByExpenseId(int ExpenseId) {
		ExpenseBean expense = pstmt.queryForObject("select * from expense_details where expense_id=?",
				new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class), new Object[] { ExpenseId });
		return expense;
	}

	public void editExpense(ExpenseBean expense) {
		pstmt.update(
				"update expense_details set expense_name=?,expense_description=?,expense_amount=?,expense_date=?,expense_paymentmode=? where expense_id=?",
				expense.getExpense_name(), expense.getExpense_description(), expense.getExpense_amount(),
				expense.getExpense_date(), expense.getExpense_paymentmode(), expense.getExpenseId());
	}
}

