package com.pbunting.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/")
@Controller
public class HomeController {

	@RequestMapping
	public String homePage() {
		return "index";
	}
}
