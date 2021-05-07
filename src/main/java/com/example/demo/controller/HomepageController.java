package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {
	@RequestMapping("/")
	public ModelAndView homeView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("homepage.jsp");
		return view;
	}
	@PostMapping("/addfile")
	public ModelAndView addfiletoDatabase() {
		ModelAndView view = new ModelAndView("redirect:/");
		//TODO add data to database
		return view;
	}
}
