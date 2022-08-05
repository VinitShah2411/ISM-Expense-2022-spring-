package com.controller;

import java.util.List;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AccountBean;
import com.bean.CategoryBean;
import com.bean.CategorySubListBean;
import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.AccountDao;
import com.dao.CategoryDao;
import com.dao.ExpenseDao;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseDao expenseDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	
	@GetMapping("/addexpense")
	public String AddExpense(Model model,ExpenseBean expense,HttpSession session)
	{
		UserBean userBean=(UserBean)session.getAttribute("user");
		int userId=userBean.getUserId();
		model.addAttribute("expense",expense);
		List<CategoryBean> categoryBean = categoryDao.getAllCategoryByUser(userId);
//		System.out.println(userId);
		model.addAttribute("category", categoryBean);
		List<CategorySubListBean> categorysublistBean = categoryDao.getAllCategoriesByUser(userId);
		model.addAttribute("categorysub", categorysublistBean);
		
		 List<List<AccountBean>> accountBean = accountDao.getAllAccountsByUserId(userId); 
			/*
			 * List<AccountBean> A1 = accountBean.get(0); // System.out.println(A1.get(0));
			 * List<AccountBean> A2 = accountBean.get(1); // System.out.println(A2.get(0));
			 * List<AccountBean> A3 = accountBean.get(2); // System.out.println(A3.get(0));
			 * model.addAttribute("account1",A1 ); model.addAttribute("account2",A2);
			 * model.addAttribute("account3",A3);
			 */
			model.addAttribute("accounts", accountBean);
			List<AccountBean> A1 = accountBean.get(0);
			model.addAttribute("A1", A1);
			System.out.println(A1.get(0).getAccount_id());
			List<AccountBean> A2 = accountBean.get(1);
			model.addAttribute("A2", A2);
			List<AccountBean> A3 = accountBean.get(2);
			model.addAttribute("A3", A3);
			return "AddExpense";
	}
	
	
	@PostMapping("/addexpense")
	public String addExpense(@ModelAttribute("expense") @Valid ExpenseBean expense,BindingResult result,Model model,HttpSession session) {
		System.out.println(result);
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "AddExpense";
		}else {
		UserBean userBean=(UserBean)session.getAttribute("user");
		int userId=userBean.getUserId();
//		System.out.println(userBean);
		expense.setUserId(userId);
		//expense.setUserId(userBean.getUserId());
		expenseDao.addExpense(expense);
		model.addAttribute(expense);
		return "Home";
		}
	}

	@GetMapping("/viewexpenses")
	public String viewExpense(HttpSession session,Model model) {
		UserBean userBean = (UserBean) session.getAttribute("user");
		int userId = userBean.getUserId();
		List<ExpenseBean> expenses = expenseDao.getAllExpenseByUser(userId);
//		System.out.println(expenses.get(0).getExpenseId());
		model.addAttribute("expenses", expenses);
		return "ListExpenses";
	}
	
	@GetMapping("/deleteexpense")
	public String deleteExpense(@RequestParam("expenseId") int expenseId) {
		expenseDao.deleteExpense(expenseId);
		return "redirect:/viewexpenses";
	}
	
	@GetMapping("/editexpense")
	public String editExpense(@RequestParam("expenseId") int expenseId,Model model) {
		ExpenseBean expense = expenseDao.getExpenseByExpenseId(expenseId);
		model.addAttribute("expense",expense);
		return "EditExpense";
	}
	
	@PostMapping("updateexpense")
	public String updateExpense(ExpenseBean expense) {
		expenseDao.editExpense(expense);
		return "redirect:/viewexpenses";
	}
	
	
	
		
}
