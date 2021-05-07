package com.example.demo.controller;

import org.springframework.stereotype.Controller;
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
}
