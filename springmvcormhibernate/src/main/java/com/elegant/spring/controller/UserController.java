package com.elegant.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elegant.spring.model.User;
import com.elegant.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String Register(@ModelAttribute("user") User user, Model model) {
		logger.info("before binding the new user.", "User");
		model.addAttribute("title", "Login");
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		logger.info("before binding the new user.", "User");
		userService.save(user);
		logger.info("after saving the new user.", "User");
		return "redirect:/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logoutl) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "Login");
		model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model) {
		return "redirect:/success";

	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String Welcome(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "Welcome Bala !!! You created user!!!!");
		return "welcome";

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String Home(Model model) {

		List<?> userlist = userService.getUserList();
		model.addAttribute("userlist", userlist);
		model.addAttribute("message", "Welcome Bala !!! You created user!!!!");
		model.addAttribute("title", "Home");
		return "welcome";

	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String Successt(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "Login");
		model.addAttribute("message", "You have loggged in successfully.");
		return "success";

	}
}
