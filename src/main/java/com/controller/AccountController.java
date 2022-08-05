package com.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AccountBean;
import com.bean.UserBean;
import com.dao.AccountDao;

@Controller
public class AccountController {

	@Autowired
	AccountDao accountDao;

	@GetMapping("/addaccount")
	public String addAccount(Model model,AccountBean accountBean) {
		model.addAttribute("account",accountBean);
		return "AddAccount";
	}

	@PostMapping("/saveaccount")
	public String addAccount(@ModelAttribute("account")  AccountBean accountBean, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("account", accountBean);
			return "AddAccount";
		} else {
			UserBean userBean = (UserBean) session.getAttribute("user");
			int userId = userBean.getUserId();
			accountBean.setUserId(userId);
			accountDao.addAccount(accountBean);
			model.addAttribute(accountBean);
			return "Home";
		}
	}
	
	@GetMapping("/listaccounts")
	public String viewAccount(HttpSession session,Model model) {
		UserBean userBean = (UserBean) session.getAttribute("user");
		int userId = userBean.getUserId();
		ArrayList<List<AccountBean>> accounts = accountDao.getAllAccountsByUserId(userId);
		List<AccountBean> A1 = accounts.get(0);
//		System.out.println(A1.get(0));
		List<AccountBean> A2 = accounts.get(1);
//		System.out.println(A2.get(0));
		List<AccountBean> A3 = accounts.get(2);
//		System.out.println(A3.get(0));
		model.addAttribute("account1",A1 );
		model.addAttribute("account2",A2);
		model.addAttribute("account3",A3);
		return "ListAccounts";
		
	}
	
}
