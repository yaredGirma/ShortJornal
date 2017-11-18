package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	BlogService blogService;

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blog(Model model) {

		model.addAttribute("posts", blogService.findAll());

		return "blog";
	}

	@RequestMapping(value = "/blog/post", method = RequestMethod.GET)
	public String post(@RequestParam Long id, Model model) {

		model.addAttribute("post",blogService.find(id));
		
		return "singlePost";
	}

}
