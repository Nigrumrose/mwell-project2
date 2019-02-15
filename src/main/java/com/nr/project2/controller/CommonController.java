package com.nr.project2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	 @GetMapping("/")
	   public String index(Model model) {

	      model.addAttribute("message", "This is home page");
	      return "index";
	   }

}
