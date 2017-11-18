package edu.mum.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.domain.Register;
import edu.mum.service.RegisterService;

@Controller
@RequestMapping({ "/registers" })
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@Autowired
	ServletContext servletContext;

	// displaying all user List
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listMembers(Model model) {
		model.addAttribute("members", registerService.findAll());
		return "members";
	}

	// getting a user Detail using register id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getRegisterById(@PathVariable("id") Long id, Model model) {
		Register member = registerService.findOne(id);
		model.addAttribute("member", member);
		return "member";
	}

	// displaying User Registration form
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String getAddNewUserRegisterForm(@ModelAttribute("newRegister") Register newRegister) {
		return "addUserRegister";
	}

	// displaying Admin Registration form
	@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
	public String getAddNewAdminRegisterForm(@ModelAttribute("newRegister") Register newRegister) {
		return "addAdminRegister";
	}

	// saving user to Register database
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String processAddNewUserRegisterForm(@ModelAttribute("newRegister") @Valid Register registerToBeAdded,
			BindingResult result) {

		if (result.hasErrors()) {
			return "addUserRegister";
		}

		MultipartFile userImage = registerToBeAdded.getUserImage();
		String rootDirectory = servletContext.getRealPath("/");

		// isEmpty means file exists BUT NO Content
		registerToBeAdded.setHasImage(false);
		if (userImage != null && !userImage.isEmpty()) {
			try {
				userImage.transferTo(new File(rootDirectory + "\\resources\\images\\"
						+ registerToBeAdded.getUserCredentials().getUsername() + ".jpg"));
				registerToBeAdded.setHasImage(true);
			} catch (Exception e) {
				throw new RuntimeException("User Image saving failed", e);
			}
		}

		// Error caught by ControllerAdvice IF no authorization...
		registerService.saveFull(registerToBeAdded);

		return "redirect:/login";

	}

	// saving Administrator user to Register database
	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public String processAddNewRegisterForm(@ModelAttribute("newRegister") @Valid Register registerToBeAdded,
			BindingResult result) {

		if (result.hasErrors()) {
			return "addAdminRegister";
		}

		// Error caught by ControllerAdvice IF no authorization...
		registerService.saveFull(registerToBeAdded);

		return "redirect:/login";

	}

	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	public String editMessage(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttribute) {
		Register newRegister = registerService.findOne(Long.parseLong(id));
		redirectAttribute.addFlashAttribute("newRegister", newRegister);
		return "redirect:/registers/addAdmin";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteMessages(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttribute) {
		Long registerId = registerService.findOne(Long.parseLong(id)).getId();
		registerService.delete(registerId);
		return "redirect:/registers";
	}

}
