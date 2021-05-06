package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {
 public ModelAndView homeView() {
	ModelAndView view = new ModelAndView();
	view.setViewName("homepage.jsp");
	return view;
 }
}
