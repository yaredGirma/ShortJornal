package edu.mum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.domain.BlogPost;
import edu.mum.service.BlogService;
import javassist.compiler.SyntaxError;

@Controller
@RequestMapping(value = "/blogManagement")
public class BlogControllerMng {

	@Autowired
	BlogService blogService;
	

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String posts(Model model) {

		
		List<BlogPost> list = blogService.findAll();
		list.forEach( x -> System.err.println(x.getTitle()));
		System.err.println("The List Size is "+ list.size());
		
		model.addAttribute("blogPosts", blogService.findAll());

		return "posts";
	}

	@RequestMapping(value = "/addPost", method = RequestMethod.GET)
	public String addPostGet(@ModelAttribute("newPost") BlogPost newpost) {

		return "addPost";
	}

	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("newPost") @Valid BlogPost newPost, BindingResult result) {

		
		if(result.hasErrors()) {
			return "addPost";
		}
		blogService.save(newPost);
		return "redirect:/blogManagement/posts";
	}

	@RequestMapping(value = "/editPost", method = RequestMethod.GET)
	public String editPostGet(@RequestParam("id") Long id, Model model, @ModelAttribute("editPost")BlogPost editPost) {

		model.addAttribute("post", blogService.find(id));
		System.err.println("Comming HEreerer "+ blogService.find(id).getDesciption());
		return "editPost";
	}

	@RequestMapping(value = "/editPost", method = RequestMethod.POST)
	public String editPost(@Valid @ModelAttribute("editPost")BlogPost editPost, BindingResult result) {

		
		if(result.hasErrors()) {
			return "editPost";
		}
		
		blogService.save(editPost);

		return "redirect:/blogManagement/posts";
	}

	@RequestMapping(value = "/remove/{postId}", method = RequestMethod.PUT	)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removePost(@PathVariable String postId, HttpServletRequest request) {

		Long id = Long.parseLong(postId);
		
		BlogPost post = blogService.find(id);
		if(post == null) {
			throw new IllegalArgumentException();
		}
		
		blogService.remove(id);

	}

}
