package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@GetMapping("/signup")
	public String Signup(Model model, UserBean user) {
		model.addAttribute("user", user);
		return "Signup";
	}

	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user") @Valid UserBean user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "Signup";
		} else {
			user.setUserType("customer");
			userDao.addUser(user);
//			System.out.println("user added");
			model.addAttribute("msg", "Signup Done");
			return "redirect:/login";
		}
	}

	@GetMapping("/login")
	public String login(Model model, LoginBean login) {
		model.addAttribute("login", login);
		return "Login";
	}

	@PostMapping("/login")
	public String authenticate(@ModelAttribute("login") @Valid LoginBean login, BindingResult result, Model model,
			HttpSession session) {
		UserBean user = userDao.authenticate(login);
		if (user == null) {
			model.addAttribute("msg", "Invalid Credentials");
			return "Login";
		} else if (user.getUserType().contentEquals("customer")) {
			session.setAttribute("user", user);
//			System.out.println(session.getAttribute("user"));
			return "Home";
		} else if (user.getUserType().contentEquals("admin")) {
			session.setAttribute("user", user);
			return "Dashboard";
		} else {
			model.addAttribute("msg", "Please Contact Admin");
			return "Login";
		}
	}

	@GetMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/home")
	public String Home() {
		return "Home";
	}

}
